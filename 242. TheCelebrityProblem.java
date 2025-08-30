class Solution {
    public int celebrity(int mat[][]) {
        
        int n = mat.length;
        int a = 0, b = n - 1;

        while (a < b) {
            if (mat[a][b] == 1) {
                a++;
            } else {
                b--;
            }
        }

        int candidate = a;
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1;
                }
            }
        }

        return candidate;
    }

}



