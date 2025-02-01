class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        helper(root,list,0);  
        return list;
    }
    
    void helper(Node root,ArrayList<ArrayList<Integer>> list,int level){
        if(root == null)
            return;
        if(level == list.size())
            list.add(new ArrayList<>());
        list.get(level).add(root.data);
        helper(root.left,list,level+1);
        helper(root.right,list,level+1);
    }
}
