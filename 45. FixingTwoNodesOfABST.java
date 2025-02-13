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
    Node first;
    Node prev;
    Node middle;
    Node last;
    void Inorder(Node root) {
        if(root == null)
        return;
        Inorder(root.left);
        if(prev!=null && root.data<prev.data) {
            if(first==null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        prev=root;
        Inorder(root.right);
    }
    
    public Node correctBST(Node root) {
        first = middle = last = null;
        prev = new Node(Integer.MIN_VALUE);
        Inorder(root);
        if(first!=null && last!=null)
        {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
        else
        {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
        return root;
    }
}
