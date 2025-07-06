

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1)); // Initialize with -1
        Stack<Integer> stack = new Stack<>(); // Stores indexes

        // Traverse the array twice to handle circular property
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i % n]) {
                result.set(stack.pop(), arr[i % n]);
            }
            if (i < n) stack.push(i); // Store index only for first pass
        }

        return result;
    }
}
