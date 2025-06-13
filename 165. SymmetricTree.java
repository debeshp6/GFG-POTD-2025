

/*
class of the node of the tree is as
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/

class Solution {
    // return true/false denoting whether the tree is Symmetric or not
    public static boolean isSymmetric(Node root) {
        // add your code here;
        if(root==null) return true;
        return help(root.left,root.right);
    }
    static boolean help(Node l,Node r){
        if(l==null && r==null) return true;
        if(l==null || r==null) return false;
        
        return (l.data==r.data)&&help(l.left,r.right)&&help(l.right,r.left);
    }
}
