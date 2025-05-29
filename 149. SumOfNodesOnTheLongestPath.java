/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */

class Solution {
    
    private int maxLen = 0;
    private int maxSum = 0;
    
    public int sumOfLongRootToLeafPath(Node root) {
        dfs(root, 0, 0);
        return maxSum;
    }
    
    private void dfs(Node node, int currLen, int currSum){
        if(node == null){
            return;
        }
        
        currLen += 1;
        currSum += node.data;
        
        if(node.left == null && node.right == null){
            if(currLen > maxLen){
                maxLen = currLen;
                maxSum = currSum;
            }else if(currLen == maxLen){
                maxSum = Math.max(maxSum, currSum);
            }
        }
        
        dfs(node.left, currLen, currSum);
        dfs(node.right, currLen, currSum);
    }
}

