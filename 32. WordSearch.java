

class Solution {
    
    public static boolean dfs(int i, int j, char[][] board, int rows, int cols, String word, int idx) {
        if (idx == word.length()) return true;
        boolean outside = i < 0 || i >= rows || j < 0 || j >= cols;
        if (outside || word.charAt(idx) != board[i][j]) return false;
        
        char currChar = board[i][j];
        board[i][j] = '*';
        boolean wordFound = false;
        if (word.charAt(idx) == currChar) {
            int[][] directions = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
            
            for (int[] dir: directions) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                
                if (dfs(ii, jj, board, rows, cols, word, idx + 1)) {
                    wordFound = true;
                    break;
                }
                    
            }
        }
        
        board[i][j] = currChar;
        return wordFound;
    }
    
    static public boolean isWordExist(char[][] mat, String word) {
        int rows = mat.length;
        int cols = mat[0].length;
       
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (word.charAt(0) == mat[i][j] && dfs(i, j, mat, rows, cols, word, 0))
                    return true;
            }
        }
       
       return false;
    }
}
