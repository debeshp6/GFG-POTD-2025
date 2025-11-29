class Solution {
    
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        Node(){
            for(int i = 0;i<26;i++){
                children[i]=null;
            }
        }
    }
    
    public static int countSubs(String s) {
        Node root = new Node();
        int counter = 0;
        for(int i=0;i<s.length();i++) {
            Node curr = root;
            for(int j=i;j<s.length();j++) {
                int index = s.charAt(j) - 'a';
                if(curr.children[index]==null) {
                    counter++;
                    curr.children[index] = new Node();
                }
                curr = curr.children[index];
            }
        }
        return counter;
    }
}
