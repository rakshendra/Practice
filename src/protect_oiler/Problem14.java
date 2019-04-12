package src.protect_oiler;

public class Problem14 {
    public static void main(String[] args){
        long max=0;
        long num = 0;
        long startTime = System.currentTimeMillis();
        for(int i=2; i<=1000000;i++){
            long t = collatz(i);
            if(t >= max){
                max = t;
                num=i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(num +" "+(endTime-startTime));
    }

    private static long collatz(long n){
        long res = n;
        if(res <= 1){
            return 1;
        }
        if(res%2==0){
            return 1+collatz(res/2);
        }
        return 2+collatz((3*res+1)/2);
    }
}
