class Solution {
    public int wordBreak(String s, String[] dictionary) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Empty string is always breakable

        // Find the maximum word length in the dictionary
        int maxWordLen = 0;
        for (String word : dictionary) {
            maxWordLen = Math.max(maxWordLen, word.length());
        }

        for (int i = 1; i <= n; i++) {
            // Only check substrings within the max word length
            for (int j = Math.max(0, i - maxWordLen); j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n] ? 1 : 0;
    }
}
