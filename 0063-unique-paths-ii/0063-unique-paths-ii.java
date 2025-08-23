class Solution {
    
    public int findways(int row, int col, int m, int n, int dp[][], int obstacleGrid[][]){
        if (row < 0 || col < 0 || obstacleGrid[row][col] == 1)
            return 0;
             
        if( row == 0 && col ==0){
            return 1;
        }
        

        if(dp[row][col]!=-1)return dp[row][col];

        int left = findways(row, col-1, m,n, dp, obstacleGrid);
        int up = findways(row-1, col, m, n, dp, obstacleGrid);
        return dp[row][col] = up + left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int [m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        return findways(m-1, n-1, m, n, dp, obstacleGrid );
        
    }
}