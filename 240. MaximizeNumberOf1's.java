

// User function Template for Java

class Solution {
    public int maxOnes(int arr[], int k) {
        int left = 0, maxOnes = 0, zeroCount = 0;

        // Use a sliding window
        for (int right = 0; right < arr.length; right++) {
            // If we encounter a 0, increase zeroCount
            if (arr[right] == 0) {
                zeroCount++;
            }

            // If zeroCount exceeds k, shrink the window from the left
            while (zeroCount > k) {
                if (arr[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update the maximum size of the window
            maxOnes = Math.max(maxOnes, right - left + 1);
        }

        return maxOnes;
    }
}
