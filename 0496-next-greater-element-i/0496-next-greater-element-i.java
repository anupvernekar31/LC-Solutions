class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums2.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        Stack < Integer > st = new Stack < > ();
        for (int i = n - 1; i >= 0; i--) {
            while (st.isEmpty() == false && st.peek() <= nums2[i]) {
                st.pop();
            }

            if (i < n) {
                if (st.isEmpty() == false) hm.put(nums2[i], st.peek()) ;
                else hm.put(nums2[i], -1);
            }

            st.push(nums2[i]);
        }
        int ans[] = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i] = hm.get(nums1[i]);
        }
        return ans;
    }
}