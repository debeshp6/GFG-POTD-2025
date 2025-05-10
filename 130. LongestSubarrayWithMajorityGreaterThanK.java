
// User function Template for Java

class Solution {
    static int longestSubarray(int[] arr, int k) {
        // Transform the array into +1 for > k and -1 for <= k
        int n = arr.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = (arr[i] > k) ? 1 : -1;
        }

        // Use a HashMap to track prefix sums and their first occurrences
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;

        // Iterate through the transformed array
        for (int i = 0; i < n; i++) {
            prefixSum += diff[i];

            // If the prefix sum is positive, we have a valid subarray from 0 to i
            if (prefixSum > 0) {
                maxLength = i + 1;
            }

            // Check if (prefixSum - 1) exists in the map
            if (prefixSumMap.containsKey(prefixSum - 1)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(prefixSum - 1));
            }

            // Add prefix sum to the map if not already present
            prefixSumMap.putIfAbsent(prefixSum, i);
        }

        return maxLength;
    }
}

