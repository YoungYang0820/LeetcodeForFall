class Solution {
    public void reverseWords(char[] str) {
        if (str == null || str.length == 0) return;
        reverse(str, 0, str.length - 1);

        int prev = 0;
        for (int i = 1; i < str.length; i++) {
            if (str[i] == ' ') {
                reverse(str, prev, i - 1);
                prev = i + 1;
            }
        }

        reverse(str, prev, str.length - 1);
    }

    private void reverse(char[] str, int low, int high) {
        while (low < high) {
            char tmp = str[low];
            str[low++] = str[high];
            str[high--] = tmp;
        }
    }
}
