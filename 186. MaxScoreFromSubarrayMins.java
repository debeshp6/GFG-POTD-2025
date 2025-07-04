

// User function Template for Java

class Solution {
    // Function to find pair with maximum sum
    public int maxSum(int arr[]) {
        // Your code goes here
        int ans = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i=0; i<n-1; i++) {
            ans = Math.max(ans, arr[i] + arr[i+1]);
        }
        
        return ans;
    }
}
