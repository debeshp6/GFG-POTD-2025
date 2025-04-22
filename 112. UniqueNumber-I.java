class Solution {
    public int findUnique(int[] arr) {
        
        int unique = 0;
        for(int num : arr) {
            unique ^= num;
        }
        
        return unique;
    }
}
