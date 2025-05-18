/* BST Node
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
} */

class Solution {

    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        Node ans[] = new Node[2];
        f(root,ans,key);
        ArrayList<Node> ret = new ArrayList<>();
        ret.add(ans[0]);
        ret.add(ans[1]);
        return ret;
    }
    
    public void f(Node root,Node ans[],int key) {
        if(root == null) return ;
        f(root.left,ans,key);
        if(root.data < key) ans[0] = root;
        if(ans[1] == null && root.data>key) ans[1] = root;
        f(root.right,ans,key);
    }
}
