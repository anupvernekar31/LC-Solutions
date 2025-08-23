class Solution {
    public int ans(int ind,int nums[], int dp[]){
        if(ind == 0)
            return nums[ind];
        if(ind<0)
            return 0;
        if(dp[ind] !=-1) return dp[ind];
        int pick = nums[ind] + ans(ind-2, nums, dp);
        int dontpick = 0+ ans(ind-1, nums, dp);
        return dp[ind] = Math.max(pick, dontpick);
    }
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return ans(nums.length-1, nums, dp);
        
    }
}