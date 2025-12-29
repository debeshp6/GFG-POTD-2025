/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node addTwoLists(Node head1, Node head2) {
        // code here
        while(head1 != null && head1.data == 0){
            head1 = head1.next;
        }
        while(head2 != null && head2.data == 0){
            head2 = head2.next;
        }
        
        head1 = reverse(head1);
        head2 = reverse(head2);
        Node res = new Node(-1);
        Node temp = res;
        int carry = 0;
        
        while(head1 != null || head2 != null || carry > 0){
            int sum = 0;
            if(head1 != null){
                sum += head1.data;
                head1 = head1.next;
            }
            if(head2 != null){
                sum += head2.data;
                head2 = head2.next;
            }
            if(carry > 0){
                sum += carry;
            }
            carry = sum / 10;
            temp.next = new Node(sum % 10);
            temp = temp.next;
        }
        return reverse(res.next);
        
    }
    private Node reverse(Node head){
        if(head == null)return null;
        Node rev = null, curr = head;
        
        while(curr != null){
            Node next = curr.next;
            curr.next = rev;
            rev = curr;
            curr = next;
        }
        return rev;
    }
}
