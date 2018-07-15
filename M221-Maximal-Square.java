class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] row = new int[m][n];
//        int[][] col = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n;j ++) {
                if (i == 0 || j == 0) {
                    row[i][j] = matrix[i][j] - '0';
//                    col[i][j] = matrix[i][j] - '0';
                }
                else {
                    row[i][j] = matrix[i][j] == '1' ? Math.min(Math.min(row[i - 1][j - 1], row[i - 1][j]), row[i][j - 1]) + 1 : 0;
//                    col[i][j] = matrix[i][j] == '1' ? Math.min(row[i - 1][j], row[i][j - 1]) + 1 : 0;
                }
                max = Math.max(max, row[i][j]);
            }
        }

        return max * max;
    }
}
