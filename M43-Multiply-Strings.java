class Solution {
    public String multiply(String num1, String num2) {
        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int[] pos = new int[num1.length() + num2.length()];
        for (int i = num1Array.length - 1; i >= 0; i--) {
            for (int j = num2Array.length - 1; j >= 0; j--) {
                int tmp = (num1Array[i] - '0') * (num2Array[j] - '0');

                int pos1 = i + j, pos2 = i + j + 1;
                int mul = tmp + pos[pos2];

                pos[pos1] += mul / 10;
                pos[pos2] = mul % 10;
            }
        }
        for (int p : pos) {
            if (p == 0 && sb.length() == 0) continue;
            sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
