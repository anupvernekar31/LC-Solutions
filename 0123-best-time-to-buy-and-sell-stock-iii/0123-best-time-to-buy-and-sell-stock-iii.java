class Solution {
    public int stocks(int ind, int buy, int dp[][][], int prices[], int cap){
        if(ind == prices.length){
            return 0;
        }
        if(cap == 0){
            return 0;
        }
        
        int profit = 0;
        
        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];
        if(buy == 1 ){
            profit =  Math.max((-prices[ind] + stocks(ind+1, 0, dp, prices, cap)), stocks(ind+1, 1, dp, prices, cap) );
        } else {
            profit =  Math.max((prices[ind] + stocks(ind+1, 1, dp, prices, cap-1)), stocks(ind+1, 0, dp, prices, cap) );
        }
        return dp[ind][buy][cap] = profit;
    }
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][3];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        
        return stocks(0, 1, dp, prices, 2);
        
    }
}