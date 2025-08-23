class Solution {
    /*  
    ====================================================================================
    DONT KNOW WHY BUT THIS SOLUTION GIVES TLE FOR 4 TEST CASES BUT SOLUTION IS CORRECT
    ====================================================================================
    static int getMaxUtil(int i, int j, int m, int[][] matrix, int[][] dp) {
        // Base Conditions
        if (j < 0 || j >= m)
            return (int) Math.pow(10, 9);
        if (i == 0)
            return matrix[0][j];

        if (dp[i][j] != -1)
            return dp[i][j];

        // Calculate three possible paths: moving up, left diagonal, and right diagonal
        int up = matrix[i][j] + getMaxUtil(i - 1, j, m, matrix, dp);
        int leftDiagonal = matrix[i][j] + getMaxUtil(i - 1, j - 1, m, matrix, dp);
        int rightDiagonal = matrix[i][j] + getMaxUtil(i - 1, j + 1, m, matrix, dp);

        // Store the maximum of the three paths in dp
        return dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        int mini = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            int ans = getMaxUtil(n - 1, j, m, matrix, dp);
            mini = Math.min(mini, ans);
        }

        return mini;
    }
    */


    // ========================================
    // TABULATION APPROACH
    // ========================================

    static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        // Initializing the first row - base condition
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Calculate the maximum path sum for each cell in the matrix
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    leftDiagonal += (int) Math.pow(10, 9);
                }

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal += (int) Math.pow(10, 9);
                }

                // Store the maximum of the three paths in dp
                dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        // Find the maximum value in the last row of dp
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, dp[n - 1][j]);
        }

        return mini;
    }
}