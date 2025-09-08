// class Solution {
//     public boolean f(int i, int j, String p, String s, int dp[][]){
//         if(i<0 && j<0) return true;

//         if(i<0 && j>=0) return false;

//         if(j<0 && i>=0){
//             for(int ii=0;ii<=i;i++){
//                 if(p.charAt(ii) != '*'){
//                     return false;
//                 }
//             }
//             return true;
//         }

//         if(dp[i][j]!=-1){
//             return dp[i][j] == 1;
//         }

//         if(s.charAt(j) == p.charAt(i) || p.charAt(i) == '?'){
//              dp[i][j] =  f(i-1, j-1, p, s, dp) ? 1:0;
//         }

//         else if(p.charAt(i) == '*'){
//              dp[i][j] =  f(i-1, j, p, s, dp) || f(i, j-1, p, s, dp) ? 1: 0;
//         }

//         else dp[i][j] =   0;

//         return dp[i][j] ==1;
//     }
//     public boolean isMatch(String s, String p) {
//         int s1 = s.length();
//         int p1 = p.length();
//         int[][] dp = new int[p1][s1];
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
//         return f(p1-1, s1-1,p ,s,  dp);
//     }
// }
//  ====================
//  TABULATION
//  =====================
class Solution {

    static boolean isAllStars(String S1, int i) {
        for (int j = 1; j <= i; j++) {
        if (S1.charAt(j - 1) != '*')
            return false;
        }
        return true;
    }
    public boolean isMatch(String S2, String S1) {
        int n = S1.length();
        int m = S2.length();

    // Create a 2D array to store the matching results
    boolean dp[][] = new boolean[n + 1][m + 1];
    dp[0][0] = true;

    // Initialize the first row and column based on wildcard '*' in S1
    for (int j = 1; j <= m; j++) {
      dp[0][j] = false;
    }
    for (int i = 1; i <= n; i++) {
      dp[i][0] = isAllStars(S1, i);
    }

    // Fill the dp array using a bottom-up approach
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?') {
          dp[i][j] = dp[i - 1][j - 1]; // Characters match or '?' is encountered.
        } else {
          if (S1.charAt(i - 1) == '*') {
            dp[i][j] = dp[i - 1][j] || dp[i][j - 1]; // '*' matches one or more characters.
          } else {
            dp[i][j] = false; // Characters don't match, and S1[i-1] is not '*'.
          }
        }
      }
    }

    return dp[n][m];
    }
}