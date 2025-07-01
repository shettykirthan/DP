package EqualSumPartition;

import java.util.Arrays;

public class EqualSumPartition {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,5,11,5}));
    }
    public static boolean canPartition(int[] nums) {
        int W =0 ;
        for(int i =0 ; i < nums.length ; i++){
            W += nums[i];
        }
        if(W % 2 != 0) return false;
        int n = nums.length;
        W = W /2;
        boolean[][] dp = new boolean[n + 1][W + 1];
        Arrays.fill(dp[0] , false);

        for(int i =0 ; i <= n ; i++) dp[i][0] = true;
        for(int i =1; i < n + 1 ; i++){
            for(int j =1 ; j < W + 1; j++ ){
                if(j - nums[i - 1] >= 0){
                    dp[i][j] = dp[i -1][j - nums[i - 1]] || dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }
}
