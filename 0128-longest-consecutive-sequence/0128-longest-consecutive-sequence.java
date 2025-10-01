class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }

        int longest = 1;

        for(int item: hs){
            if(!hs.contains(item-1)){
                int count = 1;
                int x = item;
                while(hs.contains(x+1)){
                    count++;
                    x= x+1;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }  
}