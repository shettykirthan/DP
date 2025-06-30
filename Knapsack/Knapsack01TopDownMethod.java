public class Knapsack01TopDownMethod {
    public static void main(String[] args) {
        System.out.println(knapsack(5, new int[]{10 , 40 , 30  ,50 } , new int[] {5, 4 , 2 , 3}));
    }
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int[][] dp = new int[val.length + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= W; j++) {
            dp[0][j] = 0;
        }
        for(int i =1 ; i < n + 1 ; i ++){
            for(int j =1 ; j < W + 1 ; j++){
                
                if(j - wt[ i - 1] >= 0 )dp[i][j] = Math.max(val[i - 1] + dp[i -1][j - wt[i -1]] , dp[i -1][j]);
                else dp[i][j] = dp[i -1][j];
            }
        }
        return dp[n][W];
    }
}
