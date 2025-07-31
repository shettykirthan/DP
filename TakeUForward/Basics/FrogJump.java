import java.util.*;
public class FrogJump{
    public static void main(String[] args) {
        int[] arr = {4 , 2 , 4 , 1 , 6 , 3 , 4};
        System.out.println(method1(arr));
        System.out.println(method2(arr));
        System.out.println(KJumps(arr , 3));
    }
    //memo approach
    static int method1(int[] arr){
        int n = arr.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp , -1);
        return helper1(arr , n -1 , dp);
    }
    static int helper1(int[] arr ,int n  , int[] dp){
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        int one = helper1(arr , n -1 , dp) + Math.abs(arr[n - 1] -arr[n]);
        int two = Integer.MAX_VALUE;
        if(n > 1) two = helper1(arr , n -2 , dp) +  + Math.abs(arr[n - 2] -arr[n]);
        dp[n] = Math.min(one, two);
        return dp[n];

    }


    //topdown approach
    static int method2(int[] arr){
        int n = arr.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for(int i = 1 ; i < n ; i++){
            int one = dp[i - 1] + Math.abs(arr[i - 1] - arr[i]);
            int two = Integer.MAX_VALUE;
            if(i > 1 ) two = dp[i - 2] + Math.abs(arr[i - 2] - arr[i]);
            dp[i] = Math.min(one , two);

        }
        return dp[n - 1];
    }

    //K number of jumps
    static int KJumps(int[] arr ,int k){
        int n = arr.length;
        int[] dp = new int[n + 1];      
        dp[0] = 0;
        for(int i = 1 ; i < n ; i++){
            int step = Integer.MAX_VALUE;
            for(int j = 1 ; j <= k ; j++){
                if(i - j >= 0){
                    dp[i] = Math.min(step , dp[i - j] + Math.abs(arr[i - j] - arr[i]));
                }
            }
        }
        return dp[n - 1];
    }



}