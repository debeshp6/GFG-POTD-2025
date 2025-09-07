/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node mergeKLists(Node[] arr) {
        
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        for(Node curr:arr) {
            Node temp = curr;
            while(temp != null){
                list.add(temp.data);
                temp = temp.next;
            }
        }
        
        Collections.sort(list);
        Node head = new Node(0);
        Node curr = head;
        for(int i:list){
            Node temp = new Node(i);
            curr.next = temp;
            curr = temp;
        }
        return head.next;
        
    }
}
