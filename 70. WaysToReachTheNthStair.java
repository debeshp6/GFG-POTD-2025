class Solution {
    
     int helper(int n, int[] dp) {
        if (n == 0 || n == 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        
    }
    
    int countWays(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(n, dp);
    }
}
