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
    public Node swapKth(Node head, int k) {
        
        if(head==null || head.next==null || k<=0)
            return head;
        
        int n = 0;
        Node temp = head;
        
        while(temp!=null) {
            n++;
            temp = temp.next;
        }
        
        if(k>n) return head;
        int i=k,j=n-k+1;
        if(i==j) return head;
            
        if(i>j) {
            int t = i;
            i = j;
            j = t;
        }
        
        Node prevA = null,A = head;
        
        for(int idx = 1;idx<i;idx++) {
            prevA = A;
            A = A.next;
        }
        
        Node prevB = null,B = head;
        
        for(int idx=1;idx<j;idx++)
        {
            prevB = B;
            B = B.next;
        }
        
        if(A.next==B)
        {
            if(prevA!=null)
            {
                prevA.next = B;
            }
            else
            {
                head = B;
            }
            
            A.next = B.next;
            B.next = A;
        }
        else {
           
            if (prevA != null) prevA.next = B; else head = B;
            if (prevB != null) prevB.next = A; else head = A;
            Node tmpNext = A.next;
            A.next = B.next;
            B.next = tmpNext;
        }
        
        return head;
          
    }
}
