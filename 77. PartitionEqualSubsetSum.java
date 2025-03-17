

class Solution {
    static boolean equalPartition(int arr[]) {
        // code here
        int sum  = 0;
        for(int k : arr){
            sum += k;
        }
        if(sum % 2 != 0) return false;
        
        sum = sum/2;
        
        int[][] dp = new int[arr.length+1][sum+1];
        
        for(int i = 1; i <= arr.length; i++){
            for(int j = 1; j <= sum; j++){
                if(arr[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-arr[i-1]]+arr[i-1]);
                }
            }
        }
        
        if(dp[arr.length][sum] == sum) return true;
        
        return false;
    }
}
