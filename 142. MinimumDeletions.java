class Solution {
    
    static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    
    static int minDeletions(String s) {
        return s.length() - LCS(s,reverse(s));
        
    }
    
    static int LCS(String a , String b) {
        
        int n = a.length();
        int m = b.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=n-1 ; i>=0 ; i--) {
            for(int j=m-1 ; j>=0 ; j--) {
                if(a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else{
                    dp[i][j] =  Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        
        return dp[0][0];
    }
}
