/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    
    public int findMedian(Node root) {
        int count = countNodes(root);
        int[] current = {0}; 
        int[] result = {0};  
        findMedianHelper(root, current, result, count);
        return result[0];
    }
    
    private int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private void findMedianHelper(Node root, int[] current, int[] result, int totalNodes) {
        if (root == null) return;
        findMedianHelper(root.left, current, result, totalNodes);
        current[0]++;
        if (totalNodes % 2 == 1) { 
            if (current[0] == (totalNodes + 1) / 2) {
                result[0] = root.data;
                return;
            }
        } else { 
            if (current[0] == totalNodes / 2) {
                result[0] = root.data;
                return;
            }
        }
       
        findMedianHelper(root.right, current, result, totalNodes);
    }
}
