// User function Template for Java

class Solution {
    public int findTarget(int arr[], int target) {
        // code here
        for(int i=0;i<arr.length;i++) {
            if(arr[i]==target) {
                return i;
            }
        }
        return -1;
    }
}
