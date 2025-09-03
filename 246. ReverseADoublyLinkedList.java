/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/

class Solution {
    public Node reverse(Node head) {
        while(head!=null){
            Node pre=head.next;
            head.next=head.prev;
            head.prev=pre;
            if(pre==null)return head;
            head=pre;
        }
        return head;
    }
}

