package UnboundedKnapsack;

public class count {
    public int change(int W, int[] wt) {
       int n = wt.length;
        
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1; j <= W ; j++){
                if(j - wt[ i - 1] >= 0 )dp[i][j] = dp[i][j - wt[i -1]] + dp[i -1][j];
                else{
                    dp[i][j] = dp[i -1][j];
                }
            }
        }
        return dp[n][W]; 
    }
    public static void main(String[] args) {
        count obj = new count();
        int[] wt = {1,2,5};
        int W = 5;
        System.out.println("Number of ways to make change: " + obj.change(W, wt));
    }
}
