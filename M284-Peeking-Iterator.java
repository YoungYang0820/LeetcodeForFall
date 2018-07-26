// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private class LinkedNode {
        private LinkedNode next;
        private int val;
        public LinkedNode(int val) {
            this.val = val;
        }
    }
    private LinkedNode head;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            head = new LinkedNode(0);
        LinkedNode cur = head;
        while (iterator.hasNext()) {
            cur.next = new LinkedNode(iterator.next());
            cur = cur.next;
        }
        }

    // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
        return head.next.val;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            head = head.next;
        return head.val;
        }

        @Override
        public boolean hasNext() {
            return head.next != null;
        }
}
