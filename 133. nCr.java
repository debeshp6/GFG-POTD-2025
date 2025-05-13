

class Solution {
    public int nCr(int n, int r) {
        // Base case
        if (r > n) return 0;

        // nCr is the same as nC(n-r), so use the smaller one to optimize
        r = Math.min(r, n - r);

        int[] dp = new int[r + 1];
        dp[0] = 1; // nC0 = 1

        for (int i = 1; i <= n; i++) {
            // Update from right to left to avoid overwriting values needed for next computation
            for (int j = Math.min(i, r); j > 0; j--) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[r];
    }
}
