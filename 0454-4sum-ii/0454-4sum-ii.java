class Solution {
   
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sumFreq = new HashMap<>();

        // Step 1: all pair sums of nums1 and nums2
        for (int a : nums1) {
            for (int b : nums2) {
                int s = a + b;
                sumFreq.put(s, sumFreq.getOrDefault(s, 0) + 1);
            }
        }

        // Step 2: for each pair sum in nums3 and nums4, add matches of its negation
        long count = 0; // use long to be safe during accumulation
        for (int c : nums3) {
            for (int d : nums4) {
                int t = -(c + d);
                count += sumFreq.getOrDefault(t, 0);
            }
        }

        // If you must return int (as in LeetCode), it's safe for constraints there
        return (int) count;
    }
}