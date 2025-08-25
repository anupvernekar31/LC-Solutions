class Solution {
    public int maxSubArray(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int sum = 0, start = 0, end = 0, s = 0;
         for(int i=0; i<nums.length;i++){
             sum+=nums[i];
             if(max<sum){
                max=sum;
                end = i;
                start = s;
             }
             if(sum<0){
                s=i+1;
                sum =0;
             }
         }
        System.out.print(start+" "+ end);
        return max;
        
    }
}