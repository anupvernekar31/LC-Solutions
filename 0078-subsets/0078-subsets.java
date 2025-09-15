class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        int subsets = 1<<nums.length;

        for(int num =0; num < subsets;num++){
            List<Integer> l = new ArrayList<>();
            for(int i=0;i<nums.length; i++){
                if((num & (1<<i)) !=0){
                    l.add(nums[i]);
                } 
            }
            ans.add(l);

        }
        return ans;
        
    }
}