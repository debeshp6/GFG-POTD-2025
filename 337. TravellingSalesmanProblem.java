class Solution {
    
    public int tsp(int[][] cost) {
        int n = cost.length;
        if (n == 0) return 0;
        if (n == 1) return cost[0][0]; 
        int FULL = (1 << n);
        int INF = Integer.MAX_VALUE / 4;
        int[][] dp = new int[FULL][n];
        for (int mask = 0; mask < FULL; ++mask) {
            for (int i = 0; i < n; ++i) dp[mask][i] = INF;
        }
        
        dp[1 << 0][0] = 0;
        for (int mask = 0; mask < FULL; ++mask) {
            if ((mask & 1) == 0) continue;
            for (int u = 0; u < n; ++u) {
                if ((mask & (1 << u)) == 0) continue; 
                int cur = dp[mask][u];
                if (cur >= INF) continue;
                for (int v = 0; v < n; ++v) {
                    if ((mask & (1 << v)) != 0) continue;
                    int nextMask = mask | (1 << v);
                    int cand = cur + cost[u][v];
                    if (cand < dp[nextMask][v]) dp[nextMask][v] = cand;
                }
            }
        }
        
        int fullMask = FULL - 1;
        int ans = INF;
        for (int u = 0; u < n; ++u) {
            if (dp[fullMask][u] < INF) {
                ans = Math.min(ans, dp[fullMask][u] + cost[u][0]);
            }
        }
        return ans;
    }
}
