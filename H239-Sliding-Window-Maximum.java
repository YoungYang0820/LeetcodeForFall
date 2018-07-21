class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        Deque<Integer> q = new LinkedList();
        int l = nums.length;
        int[] res = new int[l - k + 1];
        for (int i = 0; i < l; i++) {
            if (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[q.peek()];
            }
        }
        return res;
    }
}
