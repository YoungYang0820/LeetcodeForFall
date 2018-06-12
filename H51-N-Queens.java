public class Solution {
    private List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if (n <= 0) return res;
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        helper(queens, 0);
        return res;
    }

    private void helper(int[] queens, int pos) {
        if (pos == queens.length) {
            addSolution(queens);
            return;
        }
        for (int i = 0; i < queens.length; i++) {
            queens[pos] = i;
            if (isValid(queens, pos)) {
                helper(queens, pos+1);
            }
        }
    }

    private boolean isValid(int[] queens, int pos) {
        for (int i = 0; i < pos; ++i) {
            if (queens[i] == queens[pos] || Math.abs(i - pos) == Math.abs(queens[i] - queens[pos])) {
                return false;
            }
        }
        return true;
    }

    private void addSolution(int[] queens) {
        List<String> list= new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {
                if (queens[i] == j) {
                    sb.append('Q');
                }
                else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        res.add(list);
    }
}
