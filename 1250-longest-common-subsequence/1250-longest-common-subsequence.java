class Solution {
    // =========================================================================
    // THIS IS MEMOIZATION APPROACH
    // =========================================================================
    // public int lcs(int n, int m, String text1, String text2, int dp[][]){
    //     if(n<0 || m<0){
    //         return 0;
    //     }
    //     if(dp[n][m] != -1) return dp[n][m]; 
    //     if(text1.charAt(n) == text2.charAt(m)){
    //         return dp[n][m] = 1 + lcs(n-1, m-1, text1, text2,dp);
    //     }
    //     return dp[n][m] = Math.max(lcs(n-1, m, text1, text2, dp), lcs(n, m-1, text1, text2, dp));
    // }
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int n = text1.length();
    //     int m = text2.length();
    //     int dp[][] = new int[n][m];
    //     for(int i=0;i<n;i++){
    //         Arrays.fill(dp[i], -1);
    //     }
        
    //     return lcs(n -1, m-1, text1, text2, dp);
        
    // }

    // =========================================================================
    // THIS IS TABULATION APPROACH - NEEDED IN LONGEST COMMON "SUBSTRING"
    // =========================================================================

    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];


        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        return dp[n][m]; 
    }
}