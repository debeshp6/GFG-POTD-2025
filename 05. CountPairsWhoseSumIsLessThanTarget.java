// User function Template for Java
class Solution {
    int countPairs(int arr[], int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int i = 0, j = n-1;
        int cnt = 0;
        
        while(i < j) {
            if(arr[i] + arr[j] < target) {
                cnt += (j-i);
                i++;
            }
            else j--;
        }
        
        return cnt;
    }
}
