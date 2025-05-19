
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
}  */

class Solution {
    
    public static int minTime(Node root, int target) {
        int ans[]=new int[]{-1};
        f(root,ans,target);
        return ans[0];
    }
    
    public static int f(Node root,int ans[],int t){
        if(root==null) return 0;
        int left=f(root.left,ans,t);
        int right=f(root.right,ans,t);
        if(root.data==t){
            ans[0]=Math.max(left,right);
            return -1;
        }
        
        if(left<0){
            ans[0]=Math.max(ans[0],Math.abs(left)+right);
            return left-1;
        }
        if(right<0){
            ans[0]=Math.max(ans[0],Math.abs(right)+left);
            return right-1;
        }
        
        return 1+Math.max(right,left);
    }
}
