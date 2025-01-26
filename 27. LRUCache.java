
// design the class in the most optimal way

class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final DoublyLinkedList dll;

    // Constructor to initialize the LRU Cache
    public LRUCache(int cap) {
        this.capacity = cap;
        this.cache = new HashMap<>();
        this.dll = new DoublyLinkedList();
    }

    // GET operation
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1; // Key not found
        }
        Node node = cache.get(key);
        dll.moveToHead(node); // Move the accessed node to the front (most recently used)
        return node.value;
    }

    // PUT operation
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Key already exists, update its value and move to the front
            Node node = cache.get(key);
            node.value = value;
            dll.moveToHead(node);
        } else {
            // Key does not exist, create a new node
            if (cache.size() >= capacity) {
                // Cache is full, remove the least recently used node
                Node tail = dll.removeTail();
                cache.remove(tail.key);
            }
            Node newNode = new Node(key, value);
            dll.addToHead(newNode);
            cache.put(key, newNode);
        }
    }

    // Node class for doubly linked list
    private static class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Doubly linked list to maintain order of usage
    private static class DoublyLinkedList {
        private final Node head, tail;

        DoublyLinkedList() {
            head = new Node(-1, -1); // Dummy head
            tail = new Node(-1, -1); // Dummy tail
            head.next = tail;
            tail.prev = head;
        }

        // Add a node to the front (most recently used)
        void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        // Remove a node from the list
        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Move a node to the front (most recently used)
        void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        // Remove the least recently used node (at the tail)
        Node removeTail() {
            Node node = tail.prev;
            removeNode(node);
            return node;
        }
    }
}
