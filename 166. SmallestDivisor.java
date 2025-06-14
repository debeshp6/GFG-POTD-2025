class Solution {
    int smallestDivisor(int[] arr, int k) {
        // Code here
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int length = arr.length;
        int low = 1;
        int high = Arrays.stream(arr).max().getAsInt();
        int result = -1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (sumOfCeiling(arr, k, middle)) {
                result = middle;
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return result;
    }
    
    private boolean sumOfCeiling(int [] arr, int k, int possible) {
        int currentSum = 0;
        for (int num : arr) {
            int ceiling = (num + possible - 1) / possible;
            currentSum += ceiling;
        }
        return currentSum <= k;
    }
}
