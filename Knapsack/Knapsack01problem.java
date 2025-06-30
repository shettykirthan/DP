import java.util.*;

public class Knapsack01problem{
    public static void main(String[] args) {
        System.out.println(knapsack(5, new int[]{10 , 40 , 30  ,50 } , new int[] {5, 4 , 2 , 3}));
    }
    
    static int knapsack(int W, int val[], int wt[]) {

        int n = val.length;
        int[][] dp = new int[val.length + 1][W + 1];
        for (int i = 0; i <=n ; i++) {
            Arrays.fill(dp[i], -1);
        }
        return help(val , wt , W , val.length ,dp);
    }
    static int help(int val[], int wt[] , int W , int n ,int dp[][]){
        if(n == 0 || W == 0) return 0;
        if(dp[n][W] != -1) return dp[n][W];
        if(W - wt[n -1] >= 0){
            dp[n][W] = Math.max(val[n - 1] + help(val , wt , W - wt[n - 1] , n - 1,dp),help(val , wt , W , n-1,dp));
            
        }
        else{
            dp[n][W] = help(val , wt , W , n  -1,dp);
            
        }
        return dp[n][W];
    }
}
