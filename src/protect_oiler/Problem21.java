package src.protect_oiler;

import java.util.HashMap;

public class Problem21 {

    public static void main(String[] args){
        HashMap<Long, Long> numSum = new HashMap<>();
        long count=0;
        for(long i=1; i<=10000;i++){
            long j =  properDivSum(i);
            if(i<j){
                long k = properDivSum(j);
                if(i==k){
                    System.out.println(i+", "+j);
                    count+=(i+j);
                }
            }
        }

        /*for(long key: numSum.keySet()){
            long val = numSum.get(key);
            if(key < val && numSum.containsKey(val) && numSum.get(val) == key){
                count+=2;
            }
        }*/
        System.out.print(count);

    }

    private static long properDivSum(long num){
        long sum=1;

        for(long i=2; i<=num/2;i++){
            if(num%i==0){
                sum+=i;
            }
        }

        return sum;
    }

}
