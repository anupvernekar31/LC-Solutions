class Solution {
    static long countWaysToMakeChangeUtil(int[] arr, int ind, int T, long[][] dp) {
        if (ind == 0) {
            if (T % arr[0] == 0)
                return 1;
            else
                return 0;
        }

        if (dp[ind][T] != -1)
            return dp[ind][T];

        
        long notTaken = countWaysToMakeChangeUtil(arr, ind - 1, T, dp);

        long taken = 0;

        if (arr[ind] <= T)
            taken = countWaysToMakeChangeUtil(arr, ind, T - arr[ind], dp);

        return dp[ind][T] = notTaken + taken;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        long dp[][] = new long[n][amount + 1];

        for (long row[] : dp)
            Arrays.fill(row, -1);

        return (int)countWaysToMakeChangeUtil(coins, n - 1, amount, dp);
    }
}