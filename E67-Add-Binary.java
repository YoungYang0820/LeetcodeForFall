class Solution {
    public String addBinary(String a, String b) {
        int l1 = a.length();
        int l2 = b.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(l1, l2); i++) {
            int da = i < l1 ? a.charAt(l1 - i - 1) - '0' : 0;
            int db = i < l2 ? b.charAt(l2 - i - 1) - '0' : 0;
            sb.append((da + db + carry)%2);
            carry = (da + db + carry)/2;
        }
        if (carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }
}
