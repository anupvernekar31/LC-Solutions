class Solution {
    static int getAns(int arr[], int n, int ind, int prev_index, int[][] dp) {
            // Base condition
            if (ind == n) {
                return 0;
            }

            if (dp[ind][prev_index + 1] != -1) {
                return dp[ind][prev_index + 1];
            }

            int notTake = 0 + getAns(arr, n, ind + 1, prev_index, dp);

            int take = 0;

            if (prev_index == -1 || arr[ind] > arr[prev_index]) {
                take = 1 + getAns(arr, n, ind + 1, ind, dp);
            }

            dp[ind][prev_index + 1] = Math.max(notTake, take);

            return dp[ind][prev_index + 1];
        }
    
    public int lengthOfLIS(int[] nums){
        int n = nums.length;
        int dp[][] = new int[n][n + 1];
        
        // Initialize dp array with -1 to mark states as not calculated yet
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return getAns(nums, n, 0, -1, dp);
    }
    
    // public int lower_bound(ArrayList<Integer> arrayList, int key) {
    //     int low = 0, high = arrayList.size();
    //     int mid;

    //     while (low < high) {
    //         mid = low + (high - low) / 2;

    //         if (arrayList.get(mid) < key) {
    //             low = mid + 1;
    //         } else {
    //             high = mid;
    //         }
    //     }

    //     return low;
    // }
    
    // public int lengthOfLIS(int[] nums) {
        
    //     int n = nums.length;
    //     ArrayList<Integer> ans = new ArrayList<>();
    //     ans.add(nums[0]);
        
    //     for(int i=1;i<n;i++){
    //         if(nums[i] > ans.get(ans.size()-1)){
    //             ans.add(nums[i]);
    //         } else {
    //             int ind = lower_bound(ans, nums[i]);
    //             ans.set(ind, nums[i]);
    //             System.out.println(ans);
    //         }
    //     }
    //     return ans.size();
        
        
        
        
    // }
}