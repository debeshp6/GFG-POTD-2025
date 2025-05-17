/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> findSpiral(Node root) {
        // code here
        ArrayList<Integer> ans=new ArrayList<Integer>();
        if(root==null) return ans;
        Deque<Node> q=new LinkedList<>();
        q.add(root);
        boolean rev=true;
        while(!q.isEmpty()) {
            int sz=q.size();
            if(rev) {
            for(int i=0;i<sz;i++) {
                var node= q.pollLast();
                ans.add(node.data);
                if(node.right!=null)q.addFirst(node.right);
                if(node.left!=null) q.addFirst(node.left);
                }
            } else {
                for(int i=0;i<sz;i++) {
                    var node=q.pollFirst();
                    ans.add(node.data);
                    if(node.left!=null) q.addLast(node.left);
                    if(node.right!=null)q.addLast(node.right);
                }
            }
            
            rev=!rev;
        }
        
        return ans;
   }
}
