class Solution {
    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        if(n==m){
            if(s1==s2) return n;
        }else if(n<m){
            if(s2.contains(s1)) return n;
        }else{
            if(s1.contains(s2)) return m;
        }
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i = 0; i<=n; i++){
            for(int j= 0; j<=m; j++){
                if(i==0 || j==0) dp[i][j] = 0;
                else{
                    if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                    else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        
        return dp[n][m];
    }
}
