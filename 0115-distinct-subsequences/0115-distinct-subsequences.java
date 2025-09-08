class Solution {
    // =========================================
    // MEMOIZATION METHOD
    // =========================================

    // static int countUtil(String s1, String s2, int ind1, int ind2, int[][] dp) {
    //     if (ind2 < 0)
    //         return 1;
    //     if (ind1 < 0)
    //         return 0;

    //     if (dp[ind1][ind2] != -1)
    //         return dp[ind1][ind2];

    //     if (s1.charAt(ind1) == s2.charAt(ind2)) {
    //         int leaveOne = countUtil(s1, s2, ind1 - 1, ind2 - 1, dp);
    //         int stay = countUtil(s1, s2, ind1 - 1, ind2, dp);

    //         return dp[ind1][ind2] = (leaveOne + stay);
    //     } else {
    //         return dp[ind1][ind2] = countUtil(s1, s2, ind1 - 1, ind2, dp);
    //     }
    // }
    // public int numDistinct(String s, String t) {
    //     int ls = s.length();
    //     int lt = t.length();
    //     int dp[][] = new int[ls][lt];
    //     for (int rows[] : dp)
    //         Arrays.fill(rows, -1);

    //     return countUtil(s, t, ls - 1, lt - 1, dp);
    // }

    // =========================================
    // TABULATION METHOD
    // =========================================
    static int numDistinct(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) ;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }
}