class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarrayWithAtMostK(nums, k) - subarrayWithAtMostK(nums, k - 1);
    }

    public int subarrayWithAtMostK(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[n + 1]; // Array to track frequency of elements
        int count = 0; // Number of distinct elements
        int ans = 0; // Result

        int i = 0;
        for (int j = 0; j < n; j++) {
            if (freq[nums[j]] == 0) {
                count++;
            }
            freq[nums[j]]++;

            // If count exceeds k, move the left pointer i to reduce the window size
            while (count > k) {
                freq[nums[i]]--;
                if (freq[nums[i]] == 0) {
                    count--;
                }
                i++;
            }

            // For each valid window, update the answer
            ans += j - i + 1;
        }

        return ans;
    }
}