package isSubSet;

public class isSubSetOptimized {
    public static void main(String[] args) {
        System.out.println(isSubsetSum(new int[]{3 , 9}, 9));
    }
    
    static Boolean isSubsetSum(int arr[], int W) {
        // code here
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][W + 1];
        for (int j = 0; j <= W; j++) {
            dp[0][j] = false;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for(int i  = 1 ; i < n + 1 ; i++){
            for(int j = 1 ; j < W + 1 ; j++){
                
                if(j - arr[i -1] >= 0){
                    dp[i][j] = dp[i - 1][j - arr[i -1]] || dp[i - 1][j];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }


        return dp[n][W];
    }

}
