//https://www.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1

import java.util.Arrays;

public class minInsertionAndDeletion {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfce";
        int ans = minOperations(s1, s2);

        System.out.println("Minimum number of insertions and deletions: " + ans);
    }
    static int minOperations(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        // Your code goes here
        //s1 - heaf , s2 - eap
        //lcs - ea
        // heaf - eap - ea - ea
        int lcs = longestCommonSubsequenceRec(s1 , s2);
        
        return (n - lcs) + (m - lcs);
    }
    static int longestCommonSubsequenceRec(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], -1);
        return helper(text1, text2, n - 1, m - 1, dp);
    }
    static int helper(String text1, String text2, int n, int m, int[][] dp) {
        if (n < 0 || m < 0) return 0;
        if (dp[n][m] != -1) return dp[n][m];
        if (text1.charAt(n) == text2.charAt(m)) {
            return dp[n][m] = 1 + helper(text1, text2, n - 1, m - 1, dp);
        } else {
            return dp[n][m] = Math.max(
                helper(text1, text2, n - 1, m, dp),
                helper(text1, text2, n, m - 1, dp)
            );
        }
    }
}
