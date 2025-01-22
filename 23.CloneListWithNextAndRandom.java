/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*
class Node {
    int data;
    Node next, random;

    Node(int d)
    {
        data = d;
        next = random = null;

    }
}*/

class Solution {
    // Function to clone a linked list with next and random pointer.
    Node cloneLinkedList(Node head) {
        
        HashMap<Node,Node> map = new HashMap<>();
        Node temp = head;
        while(temp != null) {
            Node node = new Node(temp.data);
            map.put(temp,node);
            temp = temp.next;
        }
        
        temp = head;
        while(temp != null) {
            Node now = map.get(temp);
            now.next = map.get(temp.next);
            now.random = map.get(temp.random);
            temp = temp.next;
        }
        
        return map.get(head);
    }
}
