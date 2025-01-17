// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        
        int n = arr.length;
        int[] ans = new int[n];
        
        int prefix = 1;
        for(int i=0; i<n; i++) {
            ans[i] = prefix;
            prefix *= arr[i];
        }
        
        int suffix = 1;
        for(int i=n-1; i>=0; i--) {
            ans[i] *= suffix;
            suffix *= arr[i];
        }
        
        return ans;
    }
}
