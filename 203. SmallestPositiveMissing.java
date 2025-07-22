class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        
        int n = arr.length;
        int x = 1;
        Arrays.sort(arr);
        
        for(int i=0; i<n; i++) {
            if(arr[i] == x) x++;
            else if(arr[i] > x) break;
        }
        
        return x;
    }
}
