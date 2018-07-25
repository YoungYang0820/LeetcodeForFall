class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int mid = 0;
        int l = citations.length;
        int left = 0, right = l - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (citations[mid] >= l - mid) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return l - left;
    }
}
