class MovingAverage {
    int sum;
    int size;
    Queue<Integer> q;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList();
        sum = 0;
        this.size = size;
    }

    public double next(int val) {
        if (q.size() < size) {
            q.offer(val);
            sum += val;
        }
        else {
            sum += val - q.poll();
            q.offer(val);
        }
        return (double) sum/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
