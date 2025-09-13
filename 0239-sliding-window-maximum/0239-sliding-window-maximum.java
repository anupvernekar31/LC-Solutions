class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int start=0, end = 0, ptr = 0;
        Deque<Integer> dq = new LinkedList<Integer>();
        int[] ans = new int[nums.length - k + 1];
        
        while(end < nums.length){
            int ele = nums[end];
            while(!dq.isEmpty() && nums[end] > dq.peekLast()){
                dq.removeLast();
            }
            dq.addLast(nums[end]);
            
            if(end -start +1 < k){
                end++;
                
            } else if( end-start+1 == k){
                ans[ptr++] = dq.peekFirst();
                if(dq.peekFirst() == nums[start]){
                    dq.removeFirst();
                }
                start++;
                end++;
            }
        }
        return ans;
        
    }
}