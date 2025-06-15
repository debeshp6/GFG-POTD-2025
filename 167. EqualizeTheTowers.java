class Solution {
    public int minCost(int[] heights, int[] cost) {
        int n = heights.length;
        int[][] towers = new int[n][2];

        // Step 1: Pair heights and cost
        for (int i = 0; i < n; i++) {
            towers[i][0] = heights[i];
            towers[i][1] = cost[i];
        }

        // Step 2: Sort by heights
        Arrays.sort(towers, Comparator.comparingInt(a -> a[0]));

        // Step 3: Compute total weight (sum of all costs)
        long totalCost = 0;
        for (int i = 0; i < n; i++) {
            totalCost += towers[i][1];
        }

        // Step 4: Find weighted median
        long prefixCost = 0;
        int targetHeight = 0;
        for (int i = 0; i < n; i++) {
            prefixCost += towers[i][1];
            if (prefixCost >= (totalCost + 1) / 2) {
                targetHeight = towers[i][0];
                break;
            }
        }

        // Step 5: Calculate minimum cost to convert all to targetHeight
        long minTotalCost = 0;
        for (int i = 0; i < n; i++) {
            minTotalCost += (long)Math.abs(towers[i][0] - targetHeight) * towers[i][1];
        }

        return (int)minTotalCost;
    }
}
