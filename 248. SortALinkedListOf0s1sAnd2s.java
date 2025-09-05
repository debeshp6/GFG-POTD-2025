
/* class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}*/


class Solution {
    static Node segregate(Node head) {
        
        int[] freq = new int[3];
        Node temp = head;
        
        while(temp != null) {
            freq[temp.data]++;
            temp = temp.next;
        }
        
        temp = head;
        for(int i=0; i<3; i++){
            int count = i;
            while(freq[count]-- != 0){
                temp.data = i;
                temp = temp.next;
            }
        }
        
        return head;
    }
}


