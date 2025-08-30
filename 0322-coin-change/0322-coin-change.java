class Solution {

    int coinChangeUtil(int ind, int amount, int[][] dp, int[] coins){
        if(ind == 0){
            if(amount%coins[ind] == 0){
                return amount/coins[ind];
            } else {
                return (int) Math.pow(10, 9);
            }
        }

        if(dp[ind][amount] !=-1){
            return dp[ind][amount];
        }
        int notTake = coinChangeUtil(ind-1, amount, dp, coins);
        int take = (int) Math.pow(10, 9);
        if(coins[ind]<=amount){
            take = 1+coinChangeUtil(ind, amount-coins[ind], dp, coins);
        }

        return dp[ind][amount] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = coinChangeUtil(n-1, amount, dp, coins);
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }
}