class Solution {
    public int getCandidate(int nums[]){
        int ele=0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(count == 0){
                count = 1;
                ele = nums[i];
            }
            else if(nums[i] == ele){
                count++;
            } else {
                count--;
            }
        }
        return ele;
    }
    public int majorityElement(int[] nums) {
        int ele = getCandidate(nums);
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
            if(ele == nums[i]){
                cnt++;
            }
        }
        if(cnt>nums.length/2){
            return ele;
        }
        return -1;
    }
}