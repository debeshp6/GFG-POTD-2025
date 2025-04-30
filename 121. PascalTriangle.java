

// User function Template for Java

class Solution {

    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        
        ArrayList<Integer> rowList = new ArrayList<>();
        
        int c = 1;
        
        for (int i = 0; i < n; i++) { 
            rowList.add(c);
            c = c * (n - 1 - i) / (i + 1); 
        }
        
        return rowList;
    }
}
