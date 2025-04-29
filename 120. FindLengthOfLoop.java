

/*
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

class Solution {
    // Function to find the length of a loop in the linked list.
    private int lengthList(Node head){
        int count=1;
        Node curr=head;
        while(head!=null){
            if(curr.next==head) return count;
            count++;
            curr=curr.next;
        }
        return -1;
    }
    
    public int countNodesinLoop(Node head) {
        // code here.
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return lengthList(slow);
        }
        
        return 0;
    }
}
