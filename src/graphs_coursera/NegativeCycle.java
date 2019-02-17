package src.graphs_coursera;

import java.util.ArrayList;
import java.util.Scanner;

public class NegativeCycle {
    private static int negativeCycle(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
        long[] dist = new long[adj.length];

        for(int i=0; i < adj.length;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        for(int i=0; i<adj.length;i++){
            for(int node = 0; node < adj.length; node++){
                for(int neighbor : adj[node]){
                    long newCost = dist[node] + cost[node].get(adj[node].indexOf(neighbor));
                    if(dist[neighbor] > newCost){
                        dist[neighbor] = newCost;
                        if(i == adj.length-1){
                            return 1;
                        }
                    }
                }
            }
        }
        return 0;
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
        System.out.println(negativeCycle(adj, cost));
    }
}