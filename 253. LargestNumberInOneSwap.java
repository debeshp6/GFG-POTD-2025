

// User function Template for Java

class Solution {
    String largestSwap(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        
        // Store rightmost occurrence of each digit
        int[] lastIndex = new int[10];
        for (int i = 0; i < n; i++) {
            lastIndex[arr[i] - '0'] = i;
        }
        
        // Find the first smaller digit that can be swapped
        for (int i = 0; i < n; i++) {
            // Try to swap current digit with a larger one
            for (int d = 9; d > arr[i] - '0'; d--) {
                if (lastIndex[d] > i) { // Swap only if the larger digit appears later
                    // Swap the digits
                    char temp = arr[i];
                    arr[i] = arr[lastIndex[d]];
                    arr[lastIndex[d]] = temp;
                    
                    return new String(arr); // Return the modified string
                }
            }
        }
        
        return s; // No swap possible, return original string
    }
}
