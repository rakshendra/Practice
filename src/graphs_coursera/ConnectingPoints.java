package src.graphs_coursera;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ConnectingPoints {

    public static class Edge implements Comparable<Edge>{
        int u;
        int v;
        double dist;

        public Edge(int u, int v, double dist) {
            this.u = u;
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.dist, o.dist);
        }
    }

    private static double minimumDistance(int[] x, int[] y) {
        double result = 0.;
        //write your code here
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> o.dist));
        int[] set = new int[x.length];
        for(int i=0;i < x.length;i++){
            set[i] = i;
        }

        ArrayList<Edge> ans = new ArrayList<>();
        for(int i=0; i<x.length;i++){
            for(int j=0;j<x.length;j++){
                double distance = distance(x[i], y[i], x[j], y[j]);
                queue.add(new Edge(i, j, distance));
            }
        }

        while(!queue.isEmpty()){
            Edge e = queue.poll();
            if(findSetNum(set,e.u) != findSetNum(set,e.v)){
                ans.add(e);
                union(set, e.u, e.v);
            }
        }

        for(Edge e : ans){
            result+=e.dist;
        }

        return result;
    }

    private static int findSetNum(int[] set, int v){
        if(set[v] != v){
            return findSetNum(set, set[v]);
        }
        return v;
    }

    private static void union(int[] set, int x, int y){
        int set1 = findSetNum(set, x);
        int set2 = findSetNum(set, y);
        set[set2] = set1;
    }

    private static double distance(int x1, int y1, int x2, int y2){
        int diff1 = x1-x2;
        int diff2 = y1-y2;
        return Math.sqrt(diff1*diff1 + diff2*diff2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        System.out.println(minimumDistance(x, y));
    }
}