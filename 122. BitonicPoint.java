



// User function Template for Java

class Solution {
    public int findMaximum(int[] arr) {
        // code here
        int max = arr[0];
        int n = arr.length;
        for(int i=0; i<n; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
