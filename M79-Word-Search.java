class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int i, int j, int index) {
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        else {
            if (index == word.length() - 1) return true;
            char tmp = board[i][j];
            board[i][j] = '0';
            if (i > 0 && helper(board, word, i - 1, j, index + 1)) return true;
            if (i < board.length - 1 && helper(board, word, i + 1, j, index + 1)) return true;
            if (j > 0 && helper(board, word, i, j - 1, index + 1)) return true;
            if (j < board[0].length - 1 && helper(board, word, i, j + 1, index + 1)) return true;
            board[i][j] = tmp;
            return false;
        }
    }
}
