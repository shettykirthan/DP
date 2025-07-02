package MinimumSUBSETsumDiff;

import java.util.Arrays;

public class minisubsetsumdiff {
    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{2,5,11,5}));
    }
    public static int minDifference(int nums[]) {
        // Your code goes here
        int sum = 0;
        for(int i =0 ; i < nums.length ; i++) sum += nums[i];
        int[] s1s  = subsetsum(nums , sum);
        int min = Integer.MAX_VALUE;
        for(int i =0 ; i < s1s.length ; i++) min = Math.min(min , sum - 2 * s1s[i]);
        return min;
    }
    public static int[] subsetsum(int[] arr , int W){
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][W + 1];
        for(int i =0 ; i < W+ 1 ; i++)dp[0][i] = false;
        for(int i =0 ; i < n +1 ; i++) dp[i][0] = true;
        for(int i =1 ; i< n + 1 ; i++){
            for(int j =1 ; j < W + 1 ; j++){
                if(j - arr[i - 1] >= 0){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int[] s1s = new int[W/2 + 1];
        for(int i =0 ; i < s1s.length ; i++){
            if(dp[n][i])s1s[i] = i;
        }
        return s1s;
    }
}
