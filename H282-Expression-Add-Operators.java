class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList();
        if (num == null || num.length() == 0) return res;
        helper(res, num, "", target, 0, 0, 0);
        return res;
    }

    private void helper(List<String> res, String num, String before, int target, long tmp, long multi, int pos) {
        if (pos == num.length() && target == tmp) {
            res.add(new String(before));
        }
        for (int i = pos; i < num.length(); i++) {
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(res, num, before + cur, target, cur, cur, i + 1);
            }
            else {
                helper(res, num, before + "+" + cur, target, tmp + cur, cur, i + 1);
                helper(res, num, before + "-" + cur, target, tmp - cur, -cur, i + 1);
                helper(res, num, before + "*" + cur, target, tmp + multi * (cur - 1), multi * cur, i + 1);
            }
            if (num.charAt(pos) == '0') break;
        }

    }
}
