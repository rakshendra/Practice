package src.graphs_coursera;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        int[] dist = new int[adj.length];
        for(int i=0; i < adj.length;i++){
            dist[i]= Integer.MAX_VALUE;
        }
        Queue<Integer> queue = new LinkedList<>();
        dist[s] = 0;
        queue.add(s);
        while (!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbor : adj[node]){
                if(dist[neighbor]==Integer.MAX_VALUE){
                    queue.add(neighbor);
                    dist[neighbor] = dist[node]+1;
                }
            }
        }
        if(dist[t] < Integer.MAX_VALUE){
            return dist[t];
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}