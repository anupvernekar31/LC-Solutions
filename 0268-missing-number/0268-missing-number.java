class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        System.out.println(sum);
        int N = nums.length;
        System.out.println(N);
        int sum2 = (N*(N+1))/2;
        System.out.println(sum2);
        
        return sum2 - sum;
        
    }
}