class Solution {
    
    public int f(int n, int dp[]){
        if(n<=1)
            return n;
        
        if(dp[n]!=-1) return dp[n];
        
        return dp[n] = f(n-1, dp) + f(n-2, dp);
    }
    public int fib(int n) {
        // int dp[] = new int[n+1];
        // Arrays.fill(dp, -1);
        // return f(n, dp);      
        
        int dp[] =new int[n+1];
        
        int prev2 = 0;
        int prev = 1;
        
        if( n == 0) return 0;
        if(n == 1) return 1;
        
        
        for(int i=2;i<=n;i++){
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}