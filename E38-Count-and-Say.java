class Solution {
    public String countAndSay(int n) {
        if (n == 0) return "";
        String res = "1";
        for (int i = 2; i <= n; i++) {
            char num = res.charAt(0);
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < res.length(); j++) {
                if (res.charAt(j) == num) {
                    count++;
                }
                else {
                    sb.append(count).append(num);
                    num = res.charAt(j);
                    count = 1;
                }
            }

            sb.append(count).append(num);
            res = sb.toString();
        }
        return res;
    }
}
