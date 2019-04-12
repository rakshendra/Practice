package src.protect_oiler;

import java.io.*;
import java.util.ArrayList;

public class Problem18 {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Rakku\\IdeaProjects\\Practice\\src\\project_euler\\data18.txt");
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        while ((str = br.readLine()) != null){
            String[] nums = str.split(" ");
            ArrayList<Integer> row = new ArrayList<>();
            for(String num : nums){
                row.add(Integer.parseInt(num));
            }
            triangle.add(row);
        }

        for(ArrayList<Integer> list : triangle){
            for(Integer i : list){
                System.out.print(i+" ");
            }
            System.out.println();
        }

        int len = triangle.get(triangle.size()-1).size();
        int[][] dp = new int[len][len];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++){
            for(int j=0; j<=i;j++){
                int max = Integer.MIN_VALUE;
                int prev1 = j-1;

                if(prev1 >=0 && prev1 <i){
                    if(max < dp[i-1][prev1]){
                        max = dp[i-1][prev1];
                    }
                }

                if(j <i){
                    if(max < dp[i-1][j]){
                        max = dp[i-1][j];
                    }
                }
                dp[i][j] = max+triangle.get(i).get(j);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i : dp[len-1]){
            if(max < i){
                max = i;
            }
        }
        System.out.println("Max path value: " + max);
    }

}
