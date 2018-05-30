class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        char[] a = strs[0].toCharArray();
        char[] b = strs[strs.length-1].toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) {
                sb.append(a[i]);
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
