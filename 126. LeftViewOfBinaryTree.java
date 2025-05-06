

// User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class Solution {
    void f(Node node, ArrayList<Integer> arr, int lvl){
        if(node==null)return;
        if(arr.size()<lvl)arr.add(node.data);
        
        f(node.left, arr, lvl+1);
        f(node.right, arr, lvl+1);
    }
    
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        f(root, ans,1);
        return ans;
    }
}
