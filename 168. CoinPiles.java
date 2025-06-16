class Solution {
    public int minimumCoins(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;

        // Prefix sum
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        // Suffix sum
        long[] suffix = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + arr[i];
        }

        long minCoins = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int maxAllowed = arr[i] + k;

            // Binary search for first index where arr[j] > maxAllowed
            int left = i, right = n - 1, idx = n;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] > maxAllowed) {
                    idx = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            long leftCoins = prefix[i];  // Remove all piles before index i
            long rightCoins = 0;
            if (idx < n) {
                long total = suffix[idx];
                long target = 1L * (n - idx) * maxAllowed;
                rightCoins = total - target;
            }

            minCoins = Math.min(minCoins, leftCoins + rightCoins);
        }

        return (int) minCoins;
    }
}

