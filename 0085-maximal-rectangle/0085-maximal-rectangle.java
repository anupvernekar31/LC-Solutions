class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int maxAns = 0;
        Stack<Integer> s = new Stack<Integer>();

        for(int i=0;i<=heights.length;i++){
            while(!s.isEmpty() && (i==n || heights[s.peek()] >= heights[i])){
                int height = heights[s.peek()];
                s.pop();
                int width;
                if(s.isEmpty()){
                    width = i;
                } else {
                    width = i-s.peek()-1;
                }
                maxAns=Math.max(maxAns, height*width);
            }
            s.push(i);
        }
        return maxAns;
        
    }
    public int maximalRectangle(char[][] matrix) {
        int n= matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;
        int[] height = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            int area = largestRectangleArea(height);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}