class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int l = (l1 + l2 + 1) / 2;
        int r = (l1 + l2 + 2) / 2;
        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2;
    }

    private double getKth(int[] nums1, int s1, int[] nums2, int s2, int k) {
        if (s1 > nums1.length - 1) return nums2[s2 + k - 1];
        if (s2 > nums2.length - 1) return nums1[s1 + k - 1];
        if (k == 1) return Math.min(nums1[s1], nums2[s2]);

        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        if (s1 + k/2 - 1 < nums1.length)
            mid1 = nums1[s1 + k/2 - 1];
        if (s2 + k/2 - 1 < nums2.length)
            mid2 = nums2[s2 + k/2 - 1];

        if (mid1 < mid2)
            return getKth(nums1, s1 + k/2, nums2, s2, k - k/2);
        else
            return getKth(nums1, s1, nums2, s2 + k/2, k - k/2);
    }
}
