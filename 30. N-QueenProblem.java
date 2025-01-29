

// User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        solveNQueens(n, 0, new ArrayList<>(), result);
        return result;
    }

    private void solveNQueens(int n, int col, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        // Base case: If all queens are placed, add the solution
        if (col == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try placing the queen in each row of the current column
        for (int row = 1; row <= n; row++) {
            if (isSafe(row, col + 1, current)) {
                current.add(row); // Place the queen
                solveNQueens(n, col + 1, current, result); // Recur for the next column
                current.remove(current.size() - 1); // Backtrack
            }
        }
    }

    private boolean isSafe(int row, int col, ArrayList<Integer> current) {
        // Check if the queen can be placed at (row, col)
        for (int i = 0; i < current.size(); i++) {
            int prevRow = current.get(i);
            int prevCol = i + 1;

            // Check same row or diagonal
            if (prevRow == row || Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false;
            }
        }
        return true;
    }
}
