package src.questions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class GraphTraversals {
    public static class Graph{
        int vertices;
        ArrayList<LinkedList<Integer>> edges;

        public Graph(int vertices){
            this.vertices = vertices;
            edges = new ArrayList<>();
            for(int i=0; i < vertices;i++){
                edges.add(i,new LinkedList<>());
            }
        }

        public void addEdge(int source, int destination){
            edges.get(source).add(destination);
        }
    }

    public static void printBFS(Graph graph, int source){
        boolean[] visited = new boolean[graph.vertices];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.add(source);
        while (!queue.isEmpty()){
            int vertex = queue.poll();
            System.out.print(vertex+" ");
            for (Integer next : graph.edges.get(vertex)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public static void printDFS(Graph graph, int source){
        boolean[] visited = new boolean[graph.vertices];
        Stack<Integer> stack = new Stack<>();
        visited[source] = true;
        stack.push(source);
        while(!stack.isEmpty()){
            int vertex = stack.pop();
            System.out.print(vertex+" ");
            for(int next : graph.edges.get(vertex)){
                if(!visited[next]){
                    visited[next] = true;
                    stack.push(next);
                }
            }
        }
    }
}
