package src.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public static void main(String[] args){
        int[] arr = {3,30,34,5,9};

        System.out.println(largestNumber(arr));
    }

    public static String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for(int i=0; i<nums.length;i++){
            strNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNums, new NumComparator());
        StringBuilder ans= new StringBuilder();
        for(int i=0; i<nums.length;i++){

            ans.append(strNums[i]);
        }
        return ans.toString();
    }

    public static class NumComparator implements Comparator<String> {

        @Override
        public int compare(java.lang.String o1, java.lang.String o2) {
            String num1 = o1;
            String num2 = o2;
            if(num1.length() != num2.length()){
                boolean firstLarge = num1.length() > num2.length();
                if(firstLarge){
                    int diff = num1.length()-num2.length();
                    num2 = num2 + num1.substring(0, diff+1);
                }else{
                    int diff = num2.length()-num1.length();
                    num1 = num1 + num2.substring(0, diff+1);
                }

            }

            return Integer.compare(Integer.valueOf(num2), Integer.valueOf(num1));
        }
    }
}
