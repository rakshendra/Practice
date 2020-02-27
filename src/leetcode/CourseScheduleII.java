package src.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CourseScheduleII {
    public static class Node implements Comparable<Node> {
        int node;
        int indegree;
        public Node(int node){
            this.node=node;
            indegree=0;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.indegree, o.indegree);
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> edges = new ArrayList<>(numCourses);
        List<Node> nodes = new ArrayList<>();
        for(int i=0; i< numCourses;i++){
            nodes.add(new Node(i));
            edges.add(new ArrayList<Integer>());
        }
        for(int[] arr : prerequisites){

            edges.get(arr[1]).add(arr[0]);
            nodes.get(arr[0]).indegree++;
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        for(int i=0; i< numCourses;i++){
            if(isCyclicUtil(i, visited, recStack, edges)) return new int[0];
        }
        Collections.sort(nodes);
        int[] ans = new int[numCourses];

        return ans;
    }

    public boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack, List<List<Integer>> edges){
        if(recStack[i]) return true;
        if(visited[i]) return false;

        visited[i] = true;
        recStack[i]=true;
        List<Integer> c = edges.get(i);
        for(int edge : c){
            if(isCyclicUtil(edge, visited, recStack, edges)) return true;
        }
        recStack[i] = false;
        return false;
    }
}
