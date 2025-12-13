class Solution {
    public ArrayList<Integer> prefixSum2D(int[][] mat, int[][] queries) {
        int n = mat.length, m = mat[0].length;
        int[][] prefix = new int[n + 1][m + 1];
        
        // Build prefix sum
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefix[i][j] = mat[i - 1][j - 1] 
                             + prefix[i - 1][j] 
                             + prefix[i][j - 1] 
                             - prefix[i - 1][j - 1];
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
            int sum = prefix[r2 + 1][c2 + 1]
                    - prefix[r1][c2 + 1]
                    - prefix[r2 + 1][c1]
                    + prefix[r1][c1];
            result.add(sum);
        }
        return result;
    }
}
