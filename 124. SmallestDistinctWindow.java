

// User function Template for Java

class Solution {
    public int findSubString(String s) {
        HashSet<Character> st = new HashSet<>();
        for (char ch : s.toCharArray()) {
            st.add(ch);
        }
        
        HashMap<Character, Integer> mp = new HashMap<>();
        int i = 0, j = 0, ans = s.length(), n = st.size(), count = 0;
        
        while (j < s.length()) {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);
            if (mp.get(s.charAt(j)) == 1) {
                count++;
            }
            
            while (count == n) {
                ans = Math.min(ans, j - i + 1);
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                if (mp.get(s.charAt(i)) == 0) {
                    count--;
                }
                i++;
            }
            j++;
        }
        
        return ans;
    }
}
