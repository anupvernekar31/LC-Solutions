class Solution {

/*    // THIS IS BRUTE FORCE TO CALCULATE NUMBER OF SET BITS
    public int countSetBits(int n){
        int count = 0;

        while(n>1){
            count+= n&1;
            n = n >> 1;
        }
        if(n==1) count+=1;
        return count;
    }

    // // THIS IS OPTIMAL WAY TO CALCULATE NUMBER OF SET BITS
    public int countSetBits(int n) {
        int count = 0; 

        while (n > 0) {
            n &= (n - 1);  
            count++;  
        }
        return count;
    }


    public int[] countBits(int n) {
        int ans[] = new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i] = countSetBits(i);
        }

        return ans;
        
    }
*/

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int sub = 1;

        for (int i = 1; i <= n; i++) {
            if (sub * 2 == i) {
                sub = i;
            }

            dp[i] = dp[i - sub] + 1;
        }

        return dp;        
    }
}