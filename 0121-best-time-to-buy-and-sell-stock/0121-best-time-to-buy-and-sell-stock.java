class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0, mini = prices[0];
        
        for(int i= 0;i<prices.length;i++) {
            int cost = prices[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, prices[i]);
        }
        return profit;
        
    }
}


// Given u can buy and sell any number of times
// class Solution {
//     public int maxProfit(int[] prices) {
        
//         for(int i=1;i<n;i++){
//              if(prices[i] - prices[i-1] > 0)
//                  maxProit += prices[i] - prices[i-1];
// }
//         return profit;
        
//     }
// }