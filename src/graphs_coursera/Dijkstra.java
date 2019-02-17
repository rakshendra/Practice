package src.graphs_coursera;

import java.util.*;

public class Dijkstra {

    public static class Node{
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        int[] dist = new int[adj.length];
        int[] prev = new int[adj.length];

        for(int i=0; i < adj.length;i++){
            dist[i] = Integer.MAX_VALUE;
            prev[i] = -1;
        }
        dist[s] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        queue.add(new Node(s, dist[s]));

        while (!queue.isEmpty()){
            Node node = queue.poll();
            for(int neighbor : adj[node.index]){
                int neigh_index = adj[node.index].indexOf(neighbor);
                if(dist[neighbor] > dist[node.index] + cost[node.index].get(neigh_index)){

                    dist[neighbor] = dist[node.index] + cost[node.index].get(neigh_index);
                    prev[neighbor] = node.index;
                    queue.add(new Node(neighbor, dist[neighbor]));
                }
            }
        }
        if(dist[t] != Integer.MAX_VALUE){
            return dist[t];
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}