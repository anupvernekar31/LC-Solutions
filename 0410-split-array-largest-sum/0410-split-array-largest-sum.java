class Solution {


    public static int countStudents(int[] arr, int pages) {
        int n = arr.length; // size of array
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudent + arr[i] <= pages) {
                // add pages to current student
                pagesStudent += arr[i];
            } else {
                // add pages to next student
                students++;
                pagesStudent = arr[i];
            }
        }
        return students;
    }
    
    public int splitArray(int[] nums, int m) {
        int n=nums.length;
        if (m > n)
            return -1;

        int low = Integer.MIN_VALUE;
        int high = 0;

        for(int i=0;i<n;i++){
            low = Math.max(low, nums[i]);
            high+=nums[i];
        }
        
        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(nums, mid);
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}