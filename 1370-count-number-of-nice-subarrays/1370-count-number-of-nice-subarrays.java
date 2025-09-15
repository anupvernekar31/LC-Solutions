class Solution {
    int solution(int[] nums, int goal){
        int l=0, r=0;
        int count = 0;
        int sum = 0;
        while(r<nums.length){
            sum+=nums[r]%2;
            while(sum>goal && l<=r){
                sum-=nums[l]%2;
                l++;
            }
            count+= r-l+1;
            r++;

        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return solution(nums, k) - solution(nums, k-1);
    }
}