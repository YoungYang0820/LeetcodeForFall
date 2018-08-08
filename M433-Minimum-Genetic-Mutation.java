class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (start == end) return 0;
        HashSet<String> set = new HashSet();
        for (String str : bank) set.add(str);
        if (!set.contains(end)) return -1;
        char[] endArr = end.toCharArray();
        Queue<String> queue = new LinkedList();
        queue.offer(start);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int num = 0; num < size; num++) {
                char[] wordArr = queue.poll().toCharArray();
                for (int i = 0; i < wordArr.length; i++) {
                        for (char ch : "ACGT".toCharArray()) {
                            if (wordArr[i] != ch) {
                                char tmp = wordArr[i];
                                wordArr[i] = ch;
                                String word = new String(wordArr);
                                if (word.equals(end)) return level + 1;
                                if (set.contains(word)) {
                                    set.remove(word);
                                    queue.offer(word);
                                }
                                wordArr[i] = tmp;
                            }
                        }
                }
            }
            level++;
        }
        return -1;
    }
}
