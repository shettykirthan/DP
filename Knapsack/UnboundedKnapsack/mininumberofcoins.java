public class mininumberofcoins {
    public static void main(String[] args) {
        mininumberofcoins obj = new mininumberofcoins();
        int[] arr = {1, 2, 5};
        int W = 11;
        System.out.println("Minimum number of coins required: " + obj.coinChange(arr, W));
    }
    public int coinChange(int[] arr, int W) {
        int n = arr.length;
        int[][] dp = new int[n+1][W+1];
        for(int i =0 ; i < n+1 ; i++){
            dp[i][0] = 0;
        }
        for(int i =1 ; i < W+1 ; i++){
            dp[0][i] = Integer.MAX_VALUE - 1;
        }
        for(int i = 1 ; i < W+1 ; i++){
            if( i%arr[0] != 0) dp[1][i] = Integer.MAX_VALUE - 1;
            else dp[1][i] = i/arr[0];
        }
        for(int i = 2 ; i < n+1 ; i++){
            for(int j = 1 ; j < W+1 ; j++){
                if(j - arr[i - 1] >=0){
                    dp[i][j] = Math.min(dp[i - 1][j] , 1+dp[i][j - arr[i-1]]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W] == Integer.MAX_VALUE - 1 ? -1 : dp[n][W];
    }
}
