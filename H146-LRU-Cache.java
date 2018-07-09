class LRUCache {
    class Node {
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value) {
                this.key = key;
                this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private int count, capacity;
    private Node head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        count = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.pre = null;
        tail.pre = head;
        tail.next = null;
    }

    private void deleteNode(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private void addFirst(Node node) {
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            addFirst(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addFirst(node);
        }
        else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addFirst(node);
            }
            else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addFirst(node);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
