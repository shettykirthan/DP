package longestCommonSubString;

public class LongestCommonSubstring {

    public static int lcs(String s1, String s2, int i, int j, int count) {
        // Base case: if we reach the start of either string
        if (i == 0 || j == 0) {
            return count;
        }

        int currentCount = count;

        // If characters match, increment count and go diagonally back
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            currentCount = lcs(s1, s2, i - 1, j - 1, count + 1);
        }

        // Explore other options without extending the current substring
        int option1 = lcs(s1, s2, i, j - 1, 0);
        int option2 = lcs(s1, s2, i - 1, j, 0);

        return Math.max(currentCount, Math.max(option1, option2));
    }

    public static void main(String[] args) {
        String s1 = "abcdefghe";
        String s2 = "abfcdefghe";

        int result = lcs(s1, s2, s1.length(), s2.length(), 0);
        System.out.println("Length of Longest Common Substring: " + result);
    }
}
