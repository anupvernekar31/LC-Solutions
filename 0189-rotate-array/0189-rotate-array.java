class Solution {
    void reverse(int[] nums, int l, int r){
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
    public void rotate(int[] nums, int k) {
        int d = k % nums.length;
        if(nums.length == 1)
            return;
        reverse(nums, 0, nums.length-1);
        reverse(nums,0, d-1);
        reverse(nums, d, nums.length-1);
        
    }
}