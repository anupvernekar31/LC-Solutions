class Solution {

    public void reverse(int low, int high, int arr[]){
        while(low<high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
    public void rotate(int[][] matrix) {
        for (int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix.length/2;j++){
        //         int t = matrix[i][j];
        //         matrix[i][j] = matrix[i][matrix.length-1-j];
        //         matrix[i][matrix.length-1-j] = t;
        //     }
        // }

        for(int i=0;i<matrix.length;i++){
            reverse(0, matrix[0].length-1, matrix[i]);
        }
    }
}