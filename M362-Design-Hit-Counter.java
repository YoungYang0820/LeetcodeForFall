class HitCounter {
    private ArrayList<int[]> list;
    private int index;
    /** Initialize your data structure here. */
    public HitCounter() {
        list = new ArrayList();
        index = 0;
    }

    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int size = list.size();
        if (size > 0 && timestamp == list.get(size - 1)[0]) {
            list.get(size - 1)[1]++;
        } else {
            list.add(new int[]{timestamp, 1});
        }
    }

    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int hit = 0;
        for (int i = index; i < list.size(); i++) {
            if (list.get(i)[0] <= timestamp - 300) {
                index = i + 1;
                continue;
            }
            hit += list.get(i)[1];
        }
        return hit;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
