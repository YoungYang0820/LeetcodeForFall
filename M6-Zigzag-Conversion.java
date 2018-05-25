class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            sb.append(s.charAt(index));
            index += numRows * 2 - 2;
        }
        for (int i = 1; i < numRows - 1; i++) {
            index = i;
            while (index < s.length()) {
                sb.append(s.charAt(index));
                index += (numRows - 1 - i) * 2;
                if (index < s.length()) {
                    sb.append(s.charAt(index));
                }
                index += i * 2;
            }
        }
        index = numRows - 1;
        while (index < s.length()) {
            sb.append(s.charAt(index));
            index += numRows * 2 - 2;
        }
        return sb.toString();
    }
}
