class PhoneDirectory {
    HashSet<Integer> set;
    Queue<Integer> queue;
    int max;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        max = maxNumbers;
        set = new HashSet();
        queue = new LinkedList();
        for (int i = 0; i < maxNumbers; i++) {
            queue.offer(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (queue.size() == 0) return -1;
        int num = queue.poll();
        set.add(num);
        return num;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number < 0 || number >= max) return false;
        return !set.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (!set.contains(number)) return;
        set.remove(number);
        queue.offer(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
