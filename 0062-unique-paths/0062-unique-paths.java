class Solution {
    public int findways(int row, int col, int m, int n, int dp[][]){
        if( row == 0 && col ==0){
            return 1;
        }
        if (row < 0 || col < 0)
            return 0;

        if(dp[row][col]!=-1)return dp[row][col];

        int left = findways(row, col-1, m,n, dp);
        int up = findways(row-1, col, m, n, dp);
        return dp[row][col] = up + left;
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int [m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        return findways(m-1, n-1, m, n, dp );
        
    }
}