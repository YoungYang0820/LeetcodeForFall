class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int len = sentence.length;
        int[] nextIndex = new int[len];
        int[] times = new int[len];
        for (int i = 0; i < len; i++) {
            int cur = i;
            int curLen = 0;
            int time = 0;
            while (curLen + sentence[cur].length() <= cols) {
                curLen += sentence[cur++].length() + 1;
                if (cur == sentence.length) {
                    cur = 0;
                    time++;
                }
            }
            nextIndex[i] = cur;
            times[i] = time;
        }

        int res = 0;
        int cur = 0;
        for (int i = 0; i < rows; i++) {
            res += times[cur];
            cur = nextIndex[cur];
        }
        return res;
    }
}
