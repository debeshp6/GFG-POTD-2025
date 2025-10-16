/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

class Solution {
    
    static int sum = 0;
    public static void transformTree(Node root) {
        sum = 0;
        helper(root);
    }
    
    public static void helper(Node root) {
        if(root == null) return;
        helper(root.right);
        int temp = root.data;
        root.data = sum;
        sum += temp;
        helper(root.left);
    }
}
