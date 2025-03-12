class Solution {
    // Function to return max value that can be put in knapsack of capacity W
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int dp[] = new int[W + 1];

        // Iterate over each item
        for (int i = 0; i < n; i++) {
            // Traverse weights in reverse order to prevent overwriting previous results
            for (int j = W; j >= wt[i]; j--) {
                dp[j] = Math.max(dp[j], val[i] + dp[j - wt[i]]);
            }
        }
        return dp[W];
    }
}
