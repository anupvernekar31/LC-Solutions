class Solution {
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
    public String shortestCommonSupersequence(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];


        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (str1.charAt(ind1 - 1) == str2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        int length_of_LCS = dp[n][m]; 

        int length_of_SCS = n+m-length_of_LCS;


        char[] ans = new char[length_of_SCS];
        for(int i = 0;i<length_of_SCS;i++){
            ans[i]='$';
        }

        int index = length_of_SCS -1;
        int i = n;
        int j = m;

        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                ans[index] = str1.charAt(i-1);
                index--;
                i--;
                j--;
            } else if(dp[i-1][j] > dp[i][j-1]){
                ans[index] = str1.charAt(i-1);
                index--;
                i--;
            } else {
                ans[index] = str2.charAt(j-1);
                index--;
                j--;
            }

        }
        while(i>0){
            ans[index] = str1.charAt(i-1);
            index--;
            i--;
        }
        while(j>0){
            ans[index] = str2.charAt(j-1);
            index--;
            j--;
        }

        String res = "";
        for(Character c: ans){
            res+=c;
        }

        return res;
        
    }
}