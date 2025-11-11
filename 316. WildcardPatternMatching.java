class Solution {
    public boolean wildCard(String txt, String pat) {
        
        int n = txt.length();
        int m = pat.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        
        for (int i = 1; i <= n; i++) {
            dp[i][0] = false;
        }

        for (int j = 1; j <= m; j++) {
            if (pat.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = false;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                char ch1 = txt.charAt(i - 1); 
                char ch2 = pat.charAt(j - 1); 
                if (ch2 == '?' || ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (ch2 == '*') {
                    boolean option1 = dp[i - 1][j];
                    boolean option2 = dp[i][j - 1];
                    dp[i][j] = option1 || option2;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
}
