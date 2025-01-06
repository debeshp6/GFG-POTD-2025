



class Solution {
    public int countTriplets(int[] arr, int target) {
        int n = arr.length;
        int count = 0;

        // Iterate through each element as the first element of the triplet
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1; // Start of the remaining array
            int right = n - 1; // End of the remaining array

            // Use two pointers to find pairs that sum with arr[i] to target
            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];

                if (currentSum == target) {
                    // If we found a triplet, count all pairs (left, right)
                    if (arr[left] == arr[right]) {
                        // All elements between left and right are the same
                        int totalElements = right - left + 1;
                        count += (totalElements * (totalElements - 1)) / 2; // Combination of choosing 2 from totalElements
                        break; // No need to check further as all are the same
                    } else {
                        // Count duplicates on the left
                        int leftCount = 1;
                        while (left + 1 < right && arr[left] == arr[left + 1]) {
                            leftCount++;
                            left++;
                        }

                        // Count duplicates on the right
                        int rightCount = 1;
                        while (right - 1 > left && arr[right] == arr[right - 1]) {
                            rightCount++;
                            right--;
                        }

                        // Add the number of combinations of left and right duplicates
                        count += leftCount * rightCount;
                    }

                    // Move both pointers
                    left++;
                    right--;
                } else if (currentSum < target) {
                    left++; // We need a larger sum
                } else {
                    right--; // We need a smaller sum
                }
            }
        }

        return count;
    }
}
