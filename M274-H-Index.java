class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) a[n]++;
            else a[citations[i]]++;
        }

        int t = 0;
        for (int i = n; i >= 0; i--) {
            t += a[i];
            if (t >= i) return i;
        }
        return 0;
    }
}
