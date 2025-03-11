//Back-end complete function Template for Java

class Solution {
    static int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        int[] dp = new int[n+1];
      
        for(int i = n-1; i >= 0; i--) {
            int onestep = cost[i] + dp[i + 1];
            int twostep = Integer.MAX_VALUE;
            if(i + 2 <= n) twostep = cost[i] + dp[i +2];
            dp[i] = Math.min(onestep, twostep);
        }
        return Math.min(dp[0], dp[1]);
    }
};
