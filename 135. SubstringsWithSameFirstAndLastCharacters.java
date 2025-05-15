class Solution {
    public int countSubstring(String s) {
    
        int[] freq = new int[26]; 
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++; 
        }

        int result = 0;
        
        for (int count : freq) {
            if (count > 0) {
                result += count + (count * (count - 1)) / 2;
            }
        }

        return result;
    }
}
