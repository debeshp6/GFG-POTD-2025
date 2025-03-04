

class Solution {
    public int longestStringChain(String[] words) {
        
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dp = new HashMap<>();
        int maxLength = 1; 
        
        for (String word : words) {
            int currentLength = 1; 
            for (int i = 0; i < word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(predecessor)) {
                    currentLength = Math.max(currentLength, dp.get(predecessor) + 1);
                }
            }
            
            dp.put(word, currentLength);
            maxLength = Math.max(maxLength, currentLength);
        }
        
        return maxLength;
    }
}
