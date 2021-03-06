package src.graphs_coursera;

import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
        boolean[] visited = new boolean[adj.length];
        for(int node = 0; node < adj.length;node++){
            if(!visited[node]) {
                visited[node] = true;
                explore(adj, visited, node);
                result++;
            }
        }
        return result;
    }

    private static void explore(ArrayList<Integer>[] adj, boolean[] visited, int x){
        for(Integer node : adj[x]){
            if(!visited[node]) {
                visited[node] = true;
                explore(adj, visited, node);
            }
        }
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
        System.out.println(numberOfComponents(adj));
    }
}