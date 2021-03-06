class Solution {
    public int compareVersion(String version1, String version2) {
        String[] nums1 = (version1 + ".").split("\\.");
        String[] nums2 = (version2 + ".").split("\\.");

        int len = Math.max(nums1.length, nums2.length);
        for (int i = 0; i < len; i++) {
            Integer num1 = (i < nums1.length) ? Integer.parseInt(nums1[i]) : 0;
            Integer num2 = (i < nums2.length) ? Integer.parseInt(nums2[i]) : 0;

            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
        }
        return 0;
    }
}
