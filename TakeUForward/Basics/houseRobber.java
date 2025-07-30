//leetcode - https://leetcode.com/problems/house-robber/

import java.util.Arrays;

public class houseRobber {
    public static void main(String[] args) {
        int[] arr = {1 , 2 , 3 , 10 , 20, 50};
        System.out.println(memo(arr));
    }
    static int memo(int[] nums) {
        if(nums.length == 2) return Math.max(nums[0] , nums[1]);
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp , Integer.MIN_VALUE);
        return helper(nums , nums.length - 1 , dp);
    }
    static int helper(int[] nums , int i ,int[] dp){
        if(i == 0 ) return nums[i];
        if(i < 0) return 0;
        if(dp[i] != Integer.MIN_VALUE) return dp[i];
        dp[i] = Math.max(nums[i] + helper(nums , i -2 , dp) , helper(nums , i -1 , dp));
        return dp[i];
    }



    //topdown approach
    static int topdown(int[] nums) {
        int n = nums.length ;
        int[] dp = new int[n+ 1];
        dp[0] = 0;
        for(int i = 1 ; i < n+1 ; i++){
            dp[i] = Math.max((i > 1)?nums[i -1] + dp[i -2]:nums[i -1] , dp[i -1] );
        }
        return dp[n];
}
}
