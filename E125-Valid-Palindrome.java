class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, h = s.length() - 1;
        while (l < h) {
            char cl = s.charAt(l);
            char ch = s.charAt(h);
            if (cl == ch) {
                l++;
                h--;
            }
            else {
                if (!((cl >= 'a' && cl <= 'z') || (cl >= '0' && cl <= '9'))) l++;
                else if (!((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))) h--;
                else return false;
            }
        }
        return true;
    }
}
