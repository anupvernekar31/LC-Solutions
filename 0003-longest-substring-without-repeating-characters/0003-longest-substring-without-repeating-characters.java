class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        char[] nums = s.toCharArray();
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        int ans = 0;
        
        while(r < nums.length){
            h.put(nums[r], h.getOrDefault(nums[r], 0) + 1);
            
            if(h.size() == r-l+1){
                ans = Math.max(ans, r-l+1);
                r++;
            } else if(h.size() < r-l+1){
                while(h.size() < r-l+1) {
                    h.put(nums[l], h.get(nums[l]) -1 );
                    if(h.get(nums[l]) == 0){
                        h.remove(nums[l]);
                    }
                    l++;
                }
                r++;
            }
        }
        return ans;
    }
}