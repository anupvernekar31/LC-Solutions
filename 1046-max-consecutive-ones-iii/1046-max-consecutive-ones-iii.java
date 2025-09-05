class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, count = 0;
        int maxi = 0;
        
        while(r < nums.length){
            if( nums[r] == 0){
                count++;
            }
            
            if(count <= k){
                maxi = Math.max(r-l+1, maxi);
                r++; 
            } else if(count > k) {
                while(count > k){
                    if(nums[l] == 0){
                        count--;
                    }
                    l++;
                }
                r++; 
            }
                  
        }
        return maxi;
    }
    
    
}