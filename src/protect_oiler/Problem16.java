package src.protect_oiler;

import java.math.BigInteger;

public class Problem16 {

    public static void main(String[] args){

        String ans = BigInteger.valueOf(2).pow(1000).toString();
        int sum=0;
        for(char ch : ans.toCharArray()){
            sum+=(ch-'0');
        }
        System.out.println(sum);
    }

    private static int digitSum(double num){
        int sum=0;
        while(num > 0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }


}
