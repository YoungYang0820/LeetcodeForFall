class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix[0] == null || matrix.length == 0) return;
        int n = matrix.length;
        int axis = n % 2 == 0 ? n/2 : n/2 + 1;
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < axis; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
    }
}
