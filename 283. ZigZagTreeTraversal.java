/*
class Node {
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();

        Stack<Node> lr = new Stack<>();
        Stack<Node> rl = new Stack<>();
        
        lr.push(root);
        
        while (!lr.isEmpty() || !rl.isEmpty()) {
            
            while (!lr.isEmpty()) {
                if (lr.peek().left != null) rl.push(lr.peek().left);
                if (lr.peek().right != null) rl.push(lr.peek().right);
                
                res.add(lr.pop().data);
            }
            while (!rl.isEmpty()) {
                if (rl.peek().right != null) lr.push(rl.peek().right);
                if (rl.peek().left != null) lr.push(rl.peek().left);
                
                res.add(rl.pop().data);
            }
        }
        
        return res;
    }
}
