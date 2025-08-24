class Solution {
    
    public int stocks(int ind, int buy, int dp[][], int prices[]){
        if(ind == prices.length){
            return 0;
        }
        
        int profit = 0;
        
        if(dp[ind][buy] != -1) return dp[ind][buy];
        if(buy == 1 ){
            profit =  Math.max((-prices[ind] + stocks(ind+1, 0, dp, prices)), stocks(ind+1, 1, dp, prices) );
        } else {
            profit =  Math.max((prices[ind] + stocks(ind+1, 1, dp, prices)), stocks(ind+1, 0, dp, prices) );
        }
        return dp[ind][buy] = profit;
    }
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        
        
        return stocks(0, 1, dp, prices);
        
    }
}