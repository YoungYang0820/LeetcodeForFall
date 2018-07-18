class Solution {
    private class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    private void addWord(TrieNode root, String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.next[i] == null) curr.next[i] = new TrieNode();
            curr = curr.next[i];
        }
        curr.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet();
        if (words == null || words.length == 0) return new LinkedList();
        TrieNode root = new TrieNode();
        for (String word : words) {
            addWord(root, word);
        }

        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, res, new boolean[m][n]);
            }
        }
        return new LinkedList(res);
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, Set<String> res, boolean[][] used) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || used[i][j]) return;
        int index = board[i][j] - 'a';
        if (root.next[index] == null) return;
        if (root.next[index].word != null) res.add(root.next[index].word);
        used[i][j] = true;
        dfs(board, i - 1, j, root.next[index], res, used);
        dfs(board, i + 1, j, root.next[index], res, used);
        dfs(board, i, j - 1, root.next[index], res, used);
        dfs(board, i, j + 1, root.next[index], res, used);
        used[i][j] = false;
    }
}
