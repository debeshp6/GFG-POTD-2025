class Solution {
    public void setMatrixZeroes(int[][] mat) {
        boolean flag = false;
        for(int i = 0; i < mat.length; ++i) {
            for(int j = 0; j < mat[0].length; ++j) {
                if(mat[i][j] == 0) {
                    if(i == 0) {
                        flag = true;
                        break;
                    } else {
                        mat[i][0] = 0;
                        mat[0][j] = 0;
                    }
                }
            }
        }
        
        for(int i = 1; i < mat.length; ++i) 
            if(mat[i][0] == 0) {
                Arrays.fill(mat[i],0);
            }
            
        for(int i = 0; i < mat[0].length; ++i) {
            if(mat[0][i] == 0) {
                for(int j = 0; j < mat.length; ++j)
                    mat[j][i] = 0;
            }
        }
                    
        if(flag) Arrays.fill(mat[0],0);
    }
}
