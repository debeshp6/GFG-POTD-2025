/*
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
} */

class Solution {
    public int findMaxFork(Node root, int k) {
        int result = -1;

        while (root != null) {
            if (root.data == k) {
                return root.data; // Exact match
            }
            else if (root.data < k) {
                result = root.data; // Potential result
                root = root.right;  // Try for a closer larger value ≤ k
            } else {
                root = root.left;   // Go left as current value > k
            }
        }

        return result;
    }
}
