

// User function Template for Java

class Solution {
    String findLargest(int[] arr) {
        // code here
        String[] strArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strArr[i] = Integer.toString(arr[i]);
        }
        Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is "0", return "0"
        if (strArr[0].equals("0")) {
            return "0";
        }

        // Combine all numbers into the result
        StringBuilder result = new StringBuilder();
        for (String num : strArr) {
            result.append(num);
        }

        return result.toString();
    }
}
