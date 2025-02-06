

/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    static int preorderIndex = 0;
    static HashMap<Integer, Integer> inorderMap;
    
    public static Node buildTree(int inorder[], int preorder[]) {
        inorderMap = new HashMap<>();
        preorderIndex = 0;

        
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return constructTree(preorder, 0, inorder.length - 1);
    }

    private static Node constructTree(int[] preorder, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) return null;

        int rootValue = preorder[preorderIndex++];
        Node root = new Node(rootValue);
        int inorderIndex = inorderMap.get(rootValue);
        root.left = constructTree(preorder, inorderStart, inorderIndex - 1);
        root.right = constructTree(preorder, inorderIndex + 1, inorderEnd);

        return root;
    }

    public static void printPostorder(Node root) {
        if (root == null) return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data + " ");
    }
}
