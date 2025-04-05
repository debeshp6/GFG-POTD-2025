

class Solution {
    public int countIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int islandCount = 0;

        // Traverse the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If it's land and not visited, it's a new island
                if (grid[i][j] == 'L' && !visited[i][j]) {
                    dfs(grid, visited, i, j, n, m);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    // 8 directions
    private static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    private void dfs(char[][] grid, boolean[][] visited, int x, int y, int n, int m) {
        visited[x][y] = true;

        // Check all 8 directions
        for (int dir = 0; dir < 8; dir++) {
            int newX = x + dx[dir];
            int newY = y + dy[dir];

            if (isSafe(newX, newY, n, m, grid, visited)) {
                dfs(grid, visited, newX, newY, n, m);
            }
        }
    }

    // Utility to check valid cell
    private boolean isSafe(int x, int y, int n, int m, char[][] grid, boolean[][] visited) {
        return x >= 0 && x < n && y >= 0 && y < m &&
               grid[x][y] == 'L' && !visited[x][y];
    }
}
