class WordDictionary {
    private class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean word = false;
    }

    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.next[i] == null) curr.next[i] = new TrieNode();
            curr = curr.next[i];
        }
        curr.word = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }

    private boolean search(char[] word, int index, TrieNode start) {
        if (start.word && word.length == index) return true;
        if (word.length == index) return false;
        if (word[index] == '.') {
            for (int i = 0; i < 26; i++) {
                if (start.next[i] != null) {
                    if (search(word, index + 1, start.next[i])) return true;
                }
            }
        }
        else {
            if (start.next[word[index] - 'a'] != null) {
                return search(word, index + 1, start.next[word[index] - 'a']);
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
