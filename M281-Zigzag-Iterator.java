public class ZigzagIterator {
    private int curR;
    private int curC1 = 0;
    private int curC2 = 0;
    private List<Integer> v1, v2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        curR = v1.size() == 0 ? 1 : 0;
    }

    public int next() {
        int res = 0;
        if (curR == 0) {
            res = v1.get(curC1++);
            if (curC2 < v2.size()) curR = 1;
        }
        else {
            res = v2.get(curC2++);
            if (curC1 < v1.size()) curR = 0;
        }
        return res;
    }

    public boolean hasNext() {
        return curC1 < v1.size() || curC2 < v2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
