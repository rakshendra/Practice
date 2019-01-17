package src.questions;

//Incomplete
public class PatternMatching {

    public static int naiveAlgo(String text, String pattern){
        int n = text.length();
        int m = pattern.length();

        for(int i=0; i <= n-m;i++){
            int j=0;
            for(j=0; j < m; j++){
                if(pattern.charAt(j) != text.charAt(i+j)){
                    break;
                }
            }
            if(j==m){
                return i;
            }
        }
        return -1;
    }

    public static int kmpAlgo(String text, String pattern){
        int n = text.length();
        int m = pattern.length();

        int[] lps = new int[m];
        computeLPS(pattern, lps);
        return 0;
    }

    private static void computeLPS(String pattern, int[] lps) {
        int i=0;
        int j=1;
        lps[0]=0;
        while (j<pattern.length()){
            if(pattern.charAt(i)==pattern.charAt(j)){
                i++;
                lps[j] = i;
                j++;
            }else{
                if(i==0){
                    lps[j] = i;
                    j++;
                }else{
                    i=lps[i-1];
                }
            }
        }
    }


    public static int zAlgo(String text, String pattern){
        return 0;
    }
}
