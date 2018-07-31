class NumMatrix {
    private int[][] matrix, sum;
    private int m, n;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = m > 0 ? matrix[0].length : 0;
        this.sum = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j + 1] = matrix[i][j] + sum[i][j];
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        if (diff != 0) {
            for (int j = col; j < n; j++) {
                sum[row][j + 1] += diff;
            }
            matrix[row][col] = val;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int i = row1; i <= row2; i++) {
            res += sum[i][col2 + 1] - sum[i][col1];
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
