class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        helper(s, res, new String[4], 0);
        return res;
    }

    private void helper(String s, List<String> res, String[] tmp, int index) {
        if (index >= 4) {
            if (s.length() == 0) {
                res.add(String.join(".", tmp));
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (i > s.length()) return;
            int num = Integer.parseInt(s.substring(0, i));
            if (num >= 0 && num <= 255 ) {
                if (num > 0 && s.charAt(0) == '0') continue;
                if (num == 0 && i > 1) continue;
                tmp[index] = num + "";
                helper(s.substring(i), res, tmp, index + 1);
            }
        }
    }
}
