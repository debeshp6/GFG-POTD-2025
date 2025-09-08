/*
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
*/

class Solution {

    public Node mergeSort(Node head) {
        if(head == null || head.next == null){
            return head;
        }

        Node mid = findmid(head);
        Node temp = mid.next;
        mid.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(temp);
        return merge(left,right);
    }

    public static Node merge(Node left,Node right){
        Node result = new Node(-1);
        Node dummy = result;
        while(left!=null && right!=null){
            if(left.data <= right.data){
                dummy.next = left;
                left = left.next;
            } else {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }

        dummy.next=(left==null)?right:left;

        return result.next;

    }

    public static Node findmid(Node head){

        int cnt=0;

        Node curr=head;

        while(curr!=null){

            cnt++;

            curr=curr.next;

        }

        int mid=cnt/2;

        curr=head;

        cnt=0;

        while(curr!=null){

            cnt++;

            if(cnt==mid){

                return curr;

            }

            curr=curr.next;

        }

        return null;

    }

}
