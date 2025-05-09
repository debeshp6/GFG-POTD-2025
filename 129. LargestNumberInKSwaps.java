



class Solution {
    // Function to find the largest number after k swaps.
    static String maxNum;

    public static void findMaximumNum(char[] num, int k, int index) {
        if (k == 0 || index == num.length) return;

        char maxDigit = num[index];
        for (int i = index + 1; i < num.length; i++) {
            if (num[i] > maxDigit) {
                maxDigit = num[i];
            }
        }

        // If maxDigit is not greater, skip to next index
        if (maxDigit != num[index]) {
            k--;
        }

        for (int i = num.length - 1; i >= index; i--) {
            if (num[i] == maxDigit) {
                swap(num, index, i);
                String current = new String(num);
                if (current.compareTo(maxNum) > 0) {
                    maxNum = current;
                }

                findMaximumNum(num, k, index + 1);

                // Backtrack
                swap(num, index, i);
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        if (i == j) return;
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public String findMaximumNum(String s, int k) {
        // code here.
        maxNum = s;
        findMaximumNum(s.toCharArray(), k, 0);
        return maxNum;
    }

}
