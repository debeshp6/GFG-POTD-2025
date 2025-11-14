class Solution {
    
    public int cuts(int i, int j, int newCuts[], int[][] dp){
        if(i+1 == j) {
            return 0;     
        }
        
        if(dp[i][j] != -1) {
            return dp[i][j];   
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int k = i+1; k<j; k++) {
            int left = cuts(i, k, newCuts, dp);       
            int right = cuts(k, j, newCuts, dp);      
            int myCut = newCuts[j] - newCuts[i];     
            int total = left + right + myCut;        
            min = Math.min(total, min);              
        }
        
        return dp[i][j] = min;   
    }
    
    
    public int minCutCost(int n, int[] cuts) {
        int m = cuts.length;
        int newCuts[] = new int[m+2];
        int len = newCuts.length;
        int dp[][] = new int[len][len];
        
        for(int d[] : dp) {
            Arrays.fill(d, -1);
        }
        
        for(int i = 1; i<=m; i++){
            newCuts[i] = cuts[i-1];
        }
        
        newCuts[0] = 0;    // full scale from 0 to n
        newCuts[len-1] = n;  // the nth scale value
        Arrays.sort(newCuts);   // sorting 
        
        return cuts(0, len-1, newCuts, dp);
    }
}
