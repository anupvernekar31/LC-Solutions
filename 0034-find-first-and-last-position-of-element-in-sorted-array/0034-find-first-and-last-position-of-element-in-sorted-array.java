class Solution {

    public int findFirstPosition(int[] nums, int target){
        int n = nums.length;
        int res = -1, low=0, high = n-1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] ==  target){
                res = mid;
                high = mid - 1;
            } else if(nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    public int findLastPosition(int[] nums, int target){
        int n = nums.length;
        int res = -1, low=0, high = n-1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] ==  target){
                res = mid;
                low = mid + 1;
            } else if(nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    public int[] searchRange(int[] nums, int target) {


        int first = findFirstPosition(nums, target);

        if(first == -1){
            return new int[]{-1,-1};
        }
        int last = findLastPosition(nums, target);
        return new int[]{first, last};
        
    }
}