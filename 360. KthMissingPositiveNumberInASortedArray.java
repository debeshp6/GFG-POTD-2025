

class Solution {
    public int kthMissing(int[] arr, int k) {
        
        int n = arr.length;
        int missing = 0;
        int current = 1;
        int idx = 0;
        
        while(true) {
            if(idx<n && arr[idx] == current) idx++;
            else {
                missing++;
                if(missing == k)
                return current;
            }
            
            current++;
        }
        
    }
}
