class Solution {
    public ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat, int[][] opr) {
        int n = mat.length, m = mat[0].length;
        int[][] diff = new int[n + 2][m + 2]; // extra space for boundary
        
        // Apply difference array technique
        for (int[] op : opr) {
            int v = op[0], r1 = op[1], c1 = op[2], r2 = op[3], c2 = op[4];
            diff[r1][c1] += v;
            diff[r1][c2 + 1] -= v;
            diff[r2 + 1][c1] -= v;
            diff[r2 + 1][c2 + 1] += v;
        }
        
        // Prefix sum row-wise
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }
        
        // Prefix sum column-wise
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }
        
        // Apply diff to original matrix
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(mat[i][j] + diff[i][j]);
            }
            res.add(row);
        }
        return res;
    }
}
