class Solution {
    public static int balanceSums(int[][] mat) {
        
        int[] rowsAdd = new int[mat.length];
        int[] colAdd = new int[mat[0].length];
        int max = 0;

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                rowsAdd[i] += mat[i][j];
                colAdd[j] += mat[i][j];
                max = Math.max(max,Math.max(rowsAdd[i],colAdd[j]));
            }
        }

        int rowAddOn = 0;
        int colAddOn = 0;

        for(int i=0; i<rowsAdd.length; i++){
            rowsAdd[i] = max-rowsAdd[i];
            rowAddOn += rowsAdd[i];
        }

        for(int j = 0; j<colAdd.length; j++){
            colAdd[j] = max-colAdd[j];
            colAddOn += colAdd[j];
        }


        return Math.max(rowAddOn,colAddOn);
    }
}
