

// User function Template for Java

class Solution {
    // Function to find a solved Sudoku.
    
    static void solveSudoku(int[][] mat) {
        helper(mat);
    }
    
    static boolean helper(int mat[][]) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(mat[i][j] == 0){
                    for(int k = 1; k <= 9; k++){
                        if(isValid(i,j,mat,k)){
                            mat[i][j] = k;
                            if(helper(mat)) return true;
                            else mat[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    static boolean isValid(int row, int col, int mat[][], int k) {
        for(int i = 0; i < 9; i++){
            if(mat[row][i] == k) return false;
            
            if(mat[i][col] == k) return false;
            
            if(mat[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == k) return false;
        }
        return true;
        
    }
    
}
