

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
    int count = 0;
    public int sumK(Node root,int k) {
        if(root == null) return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        pathSum(root, k, list);
        return count;
    }
    
    public void pathSum(Node root, int k, ArrayList<Integer> list) {
       
        if(root == null) {
            return;
        }
        
        list.add(root.data);
        int total = 0;
        for(int i=list.size()-1; i>=0; i--){
            total += list.get(i);
            if(total == k) count++;
        }
        
        pathSum(root.left, k , list);
        pathSum(root.right, k, list );
        list.remove(list.size() - 1);
    }
}

 
