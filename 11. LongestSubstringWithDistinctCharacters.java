

// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int left = 0, right = 0;
        int length = 0;
        
        while (right < n) {
            if(map.containsKey(s.charAt(right))) left = Math.max(map.get(s.charAt(right)) + 1, left);
            map.put(s.charAt(right), right);
            length = Math.max(length, right - left + 1);
            right++;
        }
        
        return length;
    }
}
