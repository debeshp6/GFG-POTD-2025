

// User function Template for Java

// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    
    public static void inorder(Node root, ArrayList<Integer>vt) {
     if(root==null)
     return;
     inorder(root.left,vt);
     vt.add(root.data);
     inorder(root.right,vt);
    }
    
    public int kthSmallest(Node root, int k) {
    if(root==null || k<0) return -1;
     ArrayList<Integer>vt=new ArrayList<>();
     inorder(root,vt);
     if(vt.size()<k) return -1;
     return vt.get(k-1);
    }
}
