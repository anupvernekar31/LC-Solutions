class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;

        for(int i = 0;i<nums.length;i++){
            int num = nums[i];

            int remaining = target - num;

            if(hm.containsKey(remaining)){
                return new int[]{i, hm.get(remaining)};
            }

            hm.put(num, i);
        }
        return new int[] {};  
        
    }
}