

import java.util.Arrays;

public class unboundedknapsack {
    public static void main(String[] args) {
        int[] val = { 10, 40, 50, 70 };
        int[] wt = { 1, 3, 4, 5 };
        int W = 10;
        System.out.println("Maximum value in Knapsack = " + knapSack(val, wt, W));
    }
    static int knapSack(int val[], int wt[], int W) {
        // code here
        int n = val.length;
        
        int[][] dp = new int[n + 1][W + 1];
        for(int i =0 ; i <= n ; i++)Arrays.fill(dp[i] , 0);
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1; j <= W ; j++){
                if(j - wt[ i - 1] >= 0 )dp[i][j] = Math.max(val[i-1] + dp[i][j - wt[i -1]] , dp[i -1][j]);
                else{
                    dp[i][j] = dp[i -1][j];
                }
            }
        }
        return dp[n][W];
        
    }
}
