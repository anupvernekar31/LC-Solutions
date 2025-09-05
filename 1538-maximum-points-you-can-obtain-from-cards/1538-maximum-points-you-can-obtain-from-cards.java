class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0, rsum = 0, ans = 0;

        for(int i=0;i<k;i++){
            lsum+=cardPoints[i];
        }
        ans = lsum;
        int rightIndex = cardPoints.length-1;

        for(int i = k-1; i>=0;i--){
            lsum -= cardPoints[i];
            rsum += cardPoints[rightIndex];
            ans = Math.max(ans, lsum+rsum);
            rightIndex--;
        }
        return ans;
    }
}