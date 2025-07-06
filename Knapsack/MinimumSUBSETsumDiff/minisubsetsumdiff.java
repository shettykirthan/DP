package MinimumSUBSETsumDiff;

public class minisubsetsumdiff {

    public static void main(String[] args) {
        System.out.println("Minimum Subset Sum Difference: " + minDifference(new int[]{4, 5, 12, 5 , 9 }));
        System.out.println("Count of Subsets with Given Difference: " + count(new int[]{1, 1, 2, 3}, 1));
    }

    // ✅ Function to count subsets with a given difference
    public static int count(int nums[], int diff) {
        int W = 0;  // total sum
        int n = nums.length;
        for (int i = 0; i < n; i++) W += nums[i];

        // Edge case: (diff + W) must be even for valid partition
        if ((diff + W) % 2 != 0 || diff > W) return 0;

        int target = (diff + W) / 2;
        return countSubsetsWithSum(nums, n, target);
    }

    // ✅ Standard subset sum count DP
    public static int countSubsetsWithSum(int[] nums, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];

        // Base case: sum = 0 can be made with empty subset
        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (nums[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][W];
    }

    // ✅ Function to calculate minimum subset sum difference
    public static int minDifference(int[] nums) {
        int W = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) W += nums[i];

        boolean[][] dp = new boolean[n + 1][W + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (nums[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j <= W / 2; j++) {
            if (dp[n][j]) {
                int diff = W - 2 * j;
                min = Math.min(min, diff);
            }
        }

        return min;
    }
}
