// User function Template for Java

class Solution {
    int countPairs(int arr[], int target) {
        int n = arr.length;
        int i = 0, j = n - 1;
        int cnt = 0;

        while (i < j) {
            int sum = arr[i] + arr[j];

            if (sum == target) {
                if (arr[i] == arr[j]) {
                    // Special case: All elements between i and j are the same
                    int count = j - i + 1; // Total number of identical elements
                    cnt += (count * (count - 1)) / 2; // Count all unique pairs
                    break;
                } else {
                    // Count duplicates for arr[i]
                    int countLeft = 1, countRight = 1;

                    while (i + 1 < j && arr[i] == arr[i + 1]) {
                        countLeft++;
                        i++;
                    }
                    while (j - 1 > i && arr[j] == arr[j - 1]) {
                        countRight++;
                        j--;
                    }

                    // Add all pairs formed by these duplicates
                    cnt += countLeft * countRight;

                    // Move pointers to the next distinct elements
                    i++;
                    j--;
                }
            } else if (sum < target) {
                i++; // Increase the sum
            } else {
                j--; // Decrease the sum
            }
        }

        return cnt;
    }
}
