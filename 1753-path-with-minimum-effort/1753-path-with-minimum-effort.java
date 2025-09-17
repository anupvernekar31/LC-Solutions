class Tuple {
    int first;
    int second;
    int third;
    Tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = (int)1e9;
            }
        }

        dist[0][0] = 0;
        PriorityQueue<Tuple> q = new PriorityQueue<>((x,y) -> x.first - y.first);
        q.add(new Tuple(0,0,0));

        int[] dRow = {-1,0,1,0};
        int[] dCol = {0,1,0,-1};

        while(!q.isEmpty()){
            Tuple t = q.poll();
            int dis = t.first;
            int row = t.second;
            int col = t.third;

            if(row == n-1 && col == m-1){
                return dis;
            }

            for(int i=0;i<4;i++){
                int delR = row+ dRow[i];
                int delC = col + dCol[i];

                if(delR >= 0 && delR <n && delC >=0 && delC <m){
                    int newEffort = Math.max(dis, Math.abs(heights[row][col] - heights[delR][delC]));
                    if(newEffort< dist[delR][delC]){
                        dist[delR][delC] = newEffort;
                        q.add(new Tuple(newEffort, delR, delC));
                    }
                }
            }
        }
        return 0;
    }
}