class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int max = 0;
        String res = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String pal1 = expand(s, i, i);
            String pal2 = expand(s, i, i + 1);
            if (max < pal1.length()) {
                max = pal1.length();
                res = pal1;
            }
            if (max < pal2.length()) {
                max = pal2.length();
                res = pal2;
            }
        }
        return res;
    }

    private String expand(String s, int left, int right) {
        int i = 0;
        while (left - i >= 0 && right + i < s.length() && s.charAt(left - i) == s.charAt(right + i)) {
            i++;
        }
        return s.substring(left - i + 1, right + i);
    }
}
