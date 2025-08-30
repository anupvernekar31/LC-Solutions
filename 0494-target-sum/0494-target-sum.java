class Solution {
    
    int findWaysUtil(int ind, int target, int arr[], int[][] dp){
        if(ind == 0){
            if(target==0 && arr[0]==0)
                return 2;
            if(target==0 || target == arr[0])
                return 1;
            return 0;
        }   
        if(dp[ind][target]!=-1)
            return dp[ind][target];
        
        int notTaken = findWaysUtil(ind-1,target,arr,dp);
    
        int taken = 0;
        if(arr[ind]<=target)
            taken = findWaysUtil(ind-1,target-arr[ind],arr,dp);
        
        return dp[ind][target]= notTaken + taken;
    }
    int findTargetSumWays(int[] arr, int d) {
        // code here
        int n = arr.length;
        int sum = 0;
        for(int i: arr){
            sum+=i;
        }
        int required = (sum-d)/2;
        if(sum - d < 0 || (sum-d)%2 != 0){
            return 0;
        }
        int dp[][] = new int[n][required+1];
        
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        
        return findWaysUtil(n-1,required,arr,dp);
    }
}