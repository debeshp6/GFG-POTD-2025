class Solution {
    static int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int flips = 0, flipState = 0;
        int[] flipped = new int[n]; 

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                flipState ^= flipped[i - k]; 
            }

            if ((arr[i] ^ flipState) == 0) { 
                if (i + k > n) return -1; 
                flips++; 
                flipState ^= 1; 
                flipped[i] = 1;
            }
        }
        
        return flips;
    }
}
