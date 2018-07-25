class Solution {
    public int numWays(int n, int k) {
        if (n <= 1 || k == 0) return n * k;
        int same = k, diff = k * (k - 1);
        for (int i = 2; i < n; i++) {
            int tmp = diff;
            diff = (k - 1) * (same + diff);
            same = tmp;
        }
        return diff + same;
    }
}
