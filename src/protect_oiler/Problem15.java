package src.protect_oiler;

public class Problem15 {


    public static void main(String[] args){
        walkTheGrid(21);
    }

    private static void walkTheGrid(int n) {
        int[][] dp = new int[n+1][n+1];

        for(int i=0; i<=n;i++){
            dp[0][i]=1;
        }

        for(int i=0; i<=n;i++){
            dp[i][0]=1;
        }

        for(int i=1; i<=n;i++){
            for(int j=1; j<=n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        System.out.println(dp[n][n]);
    }
}
