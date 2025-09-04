

/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        
        if(head == null) return null;
        
        Node nextNode = null;
        Node curr = head;
        Node prev = null;
        int cnt = 0;
        
        while (curr != null && cnt < k) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            cnt++;
        }
        
        if(nextNode != null)
            head.next = reverseKGroup(nextNode,k);
            
        return prev;
    }
}

