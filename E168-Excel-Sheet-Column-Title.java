class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int num = (n - 1) % 26;
            sb.append((char) ('A' + num));
            n = (n - 1)/26;
        }
        return sb.reverse().toString();
    }
}
