class Solution {
    int solution(int[] nums, int goal){
        int l=0, r=0;
        int count = 0;
        int sum = 0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>goal && l<=r){
                sum-=nums[l];
                l++;
            }
            count+= r-l+1;
            r++;

        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        // int currentSum=0;
        // int count=0;
        // Map<Integer,Integer> map=new HashMap<>();
        // map.put(0,1);
        // for(int i=0;i<nums.length;i++){
        //     currentSum+=nums[i];
        //     int requiredn=currentSum-goal;
        //     if(map.containsKey(requiredn)){
        //         count+=map.get(requiredn);
        //     }
        //     map.put(currentSum,map.getOrDefault(currentSum,0)+1);
        // }
        // return count;

        return solution(nums, goal) - solution(nums, goal-1);
    
    }
}