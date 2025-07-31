import java.util.Arrays;

public class longestPalindromeSequence {
    public static void main(String[] args) {
        longestPalindromeSequence lps = new longestPalindromeSequence();
        String s = "bbabcbcab";
        System.out.println("Length of Longest Palindromic Subsequence: " + lps.longestPalindromeSubseq(s));
    }
    public int longestPalindromeSubseq(String s) {
        return longestCommonSubsequence(s , rev(s));
    }
    String rev(String s){
        return new StringBuilder(s).reverse().toString();
    }
    int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        Arrays.fill(dp[0], 0);
        for(int j = 1; j <= m; j++) {
            dp[0][j] = 0;
        }
        for(int i =1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
