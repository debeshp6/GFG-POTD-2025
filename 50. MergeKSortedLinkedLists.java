



// User function Template for Java
/*class Node
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

// arr is an array of Nodes of the heads of linked lists





class Solution {
    // Function to merge K sorted linked lists.
    Node mergeKLists(List<Node> arr) {
        // Min-heap to store the nodes of the linked lists
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);

        // Add the head of each linked list to the heap
        for (Node head : arr) {
            if (head != null) {
                minHeap.add(head);
            }
        }

        // Dummy node to simplify result list creation
        Node dummy = new Node(0);
        Node tail = dummy;

        // Process the heap until it's empty
        while (!minHeap.isEmpty()) {
            Node smallest = minHeap.poll(); // Extract the smallest node
            tail.next = smallest;          // Attach it to the result list
            tail = tail.next;              // Move the tail pointer

            if (smallest.next != null) {
                minHeap.add(smallest.next); // Add the next node from the list
            }
        }

        return dummy.next; // Return the merged list starting from dummy's next
    }
}
