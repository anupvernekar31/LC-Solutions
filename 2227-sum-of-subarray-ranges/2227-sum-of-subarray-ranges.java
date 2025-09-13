class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sum = 0;

        int[] minPrev = new int[n];
        int[] minNext = new int[n];
        int[] maxPrev = new int[n];
        int[] maxNext = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Less Element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            minPrev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();  // Clear stack

        // Next Less Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            minNext[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();

        // Previous Greater Element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            maxPrev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Greater Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            maxNext[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Calculate total contribution
        for (int i = 0; i < n; i++) {
            long leftMin = i - minPrev[i];
            long rightMin = minNext[i] - i;
            long leftMax = i - maxPrev[i];
            long rightMax = maxNext[i] - i;

            long totalMax = leftMax * rightMax * (long) nums[i];
            long totalMin = leftMin * rightMin * (long) nums[i];
            sum += (totalMax - totalMin);
        }

        return sum;
    }
}