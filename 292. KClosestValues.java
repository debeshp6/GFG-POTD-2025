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
    class pair {
        Node node;
        int diff;
        pair(Node node,int diff) {
            this.node=node;
            this.diff=diff;
        }
    }
    public void solve(Node node,PriorityQueue<pair>pq,int target) {
        if(node!=null) {
            solve(node.left,pq,target);
            int df=Math.abs(node.data-target);
            pq.add(new pair(node,df));
            solve(node.right,pq,target);
        }
    }
    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->{
           if(a.diff==b.diff) {
               return a.node.data-b.node.data;
           }
           return a.diff-b.diff;
        });
        if(root==null)return new ArrayList<>();
        solve(root,pq,target);
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<k;i++) {
            pair p=pq.poll();
            ans.add(p.node.data);
        }
        return ans;
    }
}
