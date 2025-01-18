/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

class Solution {
    public Node rotate(Node head, int k) {
        // add code here
        int lSize = size(head);
        k = k % lSize;
        Node reverseHead = reverseNode(head);
        // reverse first lSize-k node 
        Node nextNode = null;
        Node curr = reverseHead;
        for (int i = 0; i < lSize-k-1; i++) {
            curr = curr.next;
        }
        nextNode = curr.next;
    curr.next = null; // disconnect the first part
    Node reverseStartingNode = reverseNode(reverseHead);
    Node reverseNextNode = reverseNode(nextNode);
    // Find the last node of the first reversed segment
    Node temp = reverseStartingNode;
    while (temp.next != null) {
        temp = temp.next;
    }
    temp.next = reverseNextNode; // connect the two parts
    return reverseStartingNode;
        
    }
    private static Node reverseNode(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private static int size(Node node) {
        int count = 0;
        Node curr = node;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}
