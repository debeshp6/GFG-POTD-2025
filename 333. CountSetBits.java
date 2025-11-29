class Solution {
    public static int countSetBits(int n) {
        if (n == 0) return 0;
        int p = Integer.highestOneBit(n); 
        int x = Integer.numberOfTrailingZeros(p); 
        int bitsTill2x = x * (p >> 1);  
        int msbBits = n - p + 1;
        return bitsTill2x + msbBits + countSetBits(n - p);
    }
}
