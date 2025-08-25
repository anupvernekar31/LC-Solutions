class Triple {
    int first;
    int second;
    int time;
    public Triple(int first, int second, int time){
        this.first = first;
        this.second = second;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshOranges = 0;
        
        int vis[][] = new int[n][m];
        Queue<Triple> q = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    vis[i][j] = 2;
                    q.add(new Triple(i,j,0));
                } else {
                       vis[i][j] = 0;
                   }
                if(grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };
        
        int tm = 0;
        int count = 0;
        
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int t = q.peek().time;
            tm = Math.max(t, tm);
            q.remove();
            
            for(int i=0;i<4;i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if(nrow >=0 && nrow < n && ncol >=0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 2;
                    q.add(new Triple(nrow, ncol, t+1));
                    count++;
                }
                
            }
        }
        
        if(count!=freshOranges)
            return -1;
        return tm;
    }
}