class Solution {
    public int f(int ind, int buy, int dp[][], int prices[]){
        if(ind >= prices.length){
            return 0;
        }

        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }

        int profit = 0;

        if(buy == 1){
            profit = Math.max(-prices[ind] + f(ind+1, 0, dp,prices), f(ind+1, 1, dp, prices));
        } else {
            profit = Math.max(prices[ind] + f(ind+2, 1, dp,prices), f(ind+1, 0, dp, prices));
        }
        return dp[ind][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return f(0, 1, dp, prices);
    }
}