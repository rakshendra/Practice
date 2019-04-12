package src.protect_oiler;

public class Problem17 {
    private static int[] ones = {0, 3, 3, 5, 4, 4, 3, 5, 5, 4, 3, 6, 6, 8, 8, 7, 7, 9, 8, 8, 6};
    private static int[] ele = {0, 3, 6, 6, 5, 5, 5, 7, 6, 6};
    private static int[] hundreds = {0, 10, 10, 12, 11, 11, 10, 12, 12, 11};

    public static void main(String[] args){
        int sum=0;
        for(int i=1; i<=20;i++){
            sum+=ones[i];
        }

        int sum2=0;
        for(int i=21; i<=99; i++){
            if(i%10 != 0) {
                sum2 += ones[i%10];
                sum2 += ele[i/10];
            }else{
                sum2+=ele[i/10];
            }
        }
        sum += sum2;
        sum2 = sum;
        for(int i=1; i<=9;i++){
            sum += (hundreds[i]*100);
            sum += (3*99);
            sum += sum2;
        }
        sum+=11;
        System.out.println(sum);
        System.out.println(sum2);
    }
}
