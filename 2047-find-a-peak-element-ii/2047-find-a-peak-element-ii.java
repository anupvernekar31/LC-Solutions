class Solution {
    private int findMax(int[][] mat, int c) {
        int max = 0; 
        for (int i = 1; i < mat.length; i++) {
            if (mat[max][c] < mat[i][c]) {
                max = i; 
            }
        }
        return max; 
    }

    public int[] findPeakGrid(int[][] mat) {
        int low = 0, high = mat[0].length - 1; 
        while (low <= high) {
            int mid = low + (high - low) / 2; 
            int max = findMax(mat, mid); 
        
            int left = (mid - 1 >= 0) ? mat[max][mid - 1] : -1;
            int right = (mid + 1 < mat[0].length) ? mat[max][mid + 1] : -1;
        
        
            if (mat[max][mid] > left && mat[max][mid] > right) {
                return new int[]{max, mid}; 
            }
        
            else if (mat[max][mid] < left) {
                high = mid - 1;
            }
        
            else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}