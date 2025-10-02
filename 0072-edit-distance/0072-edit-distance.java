/*  
===========================
RECURSIVE SOLUTION
===========================
class Solution {

    public int f(int i, int j, String word1, String word2){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(word1.charAt(i) == word2.charAt(j)){
            return f(i-1,j-1,word1, word2);
        }
        return 1+Math.min(f(i-1,j,word1, word2), Math.min(f(i,j-1,word1, word2),f(i-1,j-1,word1, word2)));
    }
    public int minDistance(String word1, String word2) {
        int n= word1.length();
        int m = word2.length();
        return f(n-1,m-1, word1, word2);
    }
}
*/

// ===========================
// MEMOIZED SOLUTION
// ===========================
/*class Solution {

    public int f(int i, int j, String word1, String word2, int dp[][]){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)){
            return f(i-1,j-1,word1, word2,dp);
        }
        return 1+Math.min(f(i-1,j,word1, word2,dp), Math.min(f(i,j-1,word1, word2, dp),f(i-1,j-1,word1, word2, dp)));
    }
    public int minDistance(String word1, String word2) {
        int n= word1.length();
        int m = word2.length();
        int dp[][] = new int[n][m];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(n-1,m-1, word1, word2, dp);
    }
}*/
// ===========================
// TABULATION SOLUTION
// ===========================
class Solution {
    public int minDistance(String word1, String word2) {
        int n= word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];
        
        for(int j=0;j<=m;j++){
            dp[0][j] = j;
        }

        for(int i=0;i<=n;i++){
            dp[i][0] = i;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] =  dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }
        

        return dp[n][m];
    }
}