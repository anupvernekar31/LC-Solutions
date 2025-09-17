class tuple { 
    int first, second, third; 
    tuple(int _first, int _second, int _third) {
        this.first = _first; 
        this.second = _second; 
        this.third = _third; 
    }
}


class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<tuple> q = new LinkedList<>();  
        int n = grid.length; 
        int m = grid[0].length;

        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;
        q.add(new tuple(1, 0, 0)); 

        while(!q.isEmpty()) {
            tuple it = q.peek(); 
            q.remove(); 
            int dis = it.first; 
            int r = it.second; 
            int c = it.third; 

            if(r == n-1 && c == n-1)
                return dis;
        
            for(int delRow=-1; delRow<=1; delRow++) {
                for(int delCol=-1; delCol<=1; delCol++){
                    int newr = r + delRow;
                    int newc = c + delCol; 
                
                    if(newr >= 0 && newr < n && newc >= 0 && newc < m 
                        && grid[newr][newc] == 0 && !vis[newr][newc]) {
                        vis[newr][newc] = true;
                        q.add(new tuple(1+dis, newr, newc)); 
                    }
                }
                
            }
        }
        return -1; 
    }
}