class Solution {
    public int[] nextSmallerElement(int[] nums, int n) {
        
        int nse[] = new int[n];
        Stack < Integer > st = new Stack < > ();
        for (int i = n - 1; i >= 0; i--) {
            while (st.isEmpty() == false && nums[i] <= nums[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty() == false) 
                nse[i] = st.peek();
            else 
                nse[i] = n;
            

            st.push(i);
        }
        return nse;
    }

    public int[] previousSmallerEqualElement(int[] nums, int n) {
        
        int psee[] = new int[n];
        Stack < Integer > st = new Stack < > ();
        for (int i = 0; i < n; i++) {
            while (st.isEmpty() == false && nums[i] < nums[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty() == false) 
                psee[i] = st.peek();
            else 
                psee[i] = -1;
            

            st.push(i);
        }
        return psee;
    }
    public int sumSubarrayMins(int[] arr) {

        int[] nse = nextSmallerElement(arr, arr.length);
        int[] psee = previousSmallerEqualElement(arr, arr.length);
        int sum = 0; int mod= (int)1e9+7;

        for(int i=0;i<arr.length;i++){
            long left = i - psee[i];
            long right = nse[i] - i;
            long contrib = (arr[i] * left % mod * right % mod) % mod;
            sum = (int)((sum + contrib) % mod);
        }
        return sum;
    }
}