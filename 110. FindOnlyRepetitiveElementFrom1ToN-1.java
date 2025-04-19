// User function Template for Java

class Solution {
    
    public long findDuplicate(int[] arr) {
        
        long n = arr.length;
        long arraysum = 0;
        for(int i = 0; i < n; i++) {
            
            arraysum += arr[i];
        }
        
        long target = arraysum - n*(n-1)/2;
        return target;
    }
}
