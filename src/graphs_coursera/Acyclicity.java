package src.graphs_coursera;

import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {
    private static int acyclic(ArrayList<Integer>[] adj) {
        boolean[] visited = new boolean[adj.length];
        boolean[] currPath = new boolean[adj.length];

        for(int node = 0; node < adj.length;node++){
            if(!visited[node]) {
                if(explore(adj, visited, currPath, node)){
                    return 1;
                }
            }
        }
        return 0;
    }

    private static boolean explore(ArrayList<Integer>[] adj, boolean[] visited, boolean[] currPath, int x){
        visited[x] = true;
        currPath[x] = true;

        for(Integer node : adj[x]){
            if(!visited[node] && explore(adj, visited, currPath, node)){
                return true;
            }else if(currPath[node]){
                return true;
            }
        }
        currPath[x] = false;
        return false;
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
        }
        System.out.println(acyclic(adj));
    }
}


