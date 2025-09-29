class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarrayWithAtMostK(nums, k) - subarrayWithAtMostK(nums, k - 1);
    }

    public int subarrayWithAtMostK(int[] nums, int k) {
        int n = nums.length;
        int left=0, right = 0;
        int ans =0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        while(right < n) {
            hm.put(nums[right], hm.getOrDefault(nums[right], 0) +1);
            
            // If count exceeds k, move the left pointer i to reduce the window size
            while (hm.size() > k) {
                hm.put(nums[left], hm.get(nums[left]) - 1);
                if (hm.get(nums[left]) == 0) {
                    hm.remove(nums[left]);
                }
                left++;
            }

            // For each valid window, update the answer
            ans += right - left + 1;
            right++;
        }

        return ans;
    }
}