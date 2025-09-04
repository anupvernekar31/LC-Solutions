class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>(); // preSum, num of preSum
        map.put(0, 1);
        int pre = 0;
        int results = 0;
        for(int num : nums){
            pre += num;
            if(map.containsKey(pre - k)){
                results += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return results;
        
    }
}