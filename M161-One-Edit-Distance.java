class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int i1 = 0;
        while (i1 < s.length() && i1 < t.length()) {
            if (s.charAt(i1) != t.charAt(i1)) {
                boolean i = insert(s, t, i1, i1 + 1);
                boolean d = insert(s, t, i1 + 1, i1);
                boolean r = insert(s, t, i1 + 1, i1 + 1);
                return i || d || r;
            }
            i1++;
        }
        if (i1 == s.length()) return t.length() - i1 == 1;
        return s.length() - i1 == 1;
    }

    private boolean insert(String s, String t, int i1, int i2) {
        while (i1 < s.length() && i2 < t.length()) {
            if (s.charAt(i1) != t.charAt(i2)) return false;
            i1++;
            i2++;
        }
        return i1 == s.length() && i2 == t.length();
    }

}
