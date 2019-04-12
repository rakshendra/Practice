package src.protect_oiler;

import java.util.HashMap;

public class Problem12 {

    public static void main(String[] args){
        long i=2;
        HashMap<Long, Long> dp = new HashMap<>();
        dp.put(1L,1L);
        dp.put(2L,2L);

        for(;;i++){
            long first, second;

            if(i%2==0){
                long key = i / 2;
                if(dp.containsKey(key)){
                    first = dp.get(key);
                }else{
                    first = countDivisors(key);
                    dp.put(key, first);
                }

                if(dp.containsKey(i+1)){
                    second = dp.get(i+1);
                }else{
                    second = countDivisors(i+1);
                    dp.put(i+1, second);
                }
                if(first * second >= 500){
                    System.out.println((i*(i+1)/2));
                    break;
                }
            }else{
                long key = (i+1) / 2;
                if(dp.containsKey(key)){
                    first = dp.get(key);
                }else{
                    first = countDivisors(key);
                    dp.put(key, first);
                }

                if(dp.containsKey(i)){
                    second = dp.get(i);
                }else{
                    second = countDivisors(i);
                    dp.put(i, second);
                }
                if(first * second >= 500){
                    System.out.println((i*(i+1)/2));
                    break;
                }
            }

        }
    }

    private static int countDivisors(long num){
        int count=2;
        long range = (long) Math.sqrt(num);

        for(int i=2; i<=range; i++){
            if(num%i==0){
                count+=2;
            }
            if(i*i==num){
                count-=1;
            }
        }
        return count;
    }

}
