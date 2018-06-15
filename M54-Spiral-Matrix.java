class Solution {
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;
    private ArrayList<Integer> res;
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return new ArrayList<Integer>();
        minX = -1;
        minY = -1;
        maxX = matrix[0].length;
        maxY = matrix.length;
        res = new ArrayList<>();
        forward(matrix, 0, 0, 1);
        return res;
    }
    private void forward(int[][] matrix, int x, int y, int dir) {
        if (dir == 1) {
            if (x == maxX) return;
            while (x < maxX) {
                res.add(matrix[y][x++]);
            }
            minY = y;
            forward(matrix, --x, ++y, 2);
        }
        else if (dir == 2) {
            if (y == maxY) return;
            while (y < maxY) {
                res.add(matrix[y++][x]);
            }
            maxX = x;
            forward(matrix, --x, --y, 3);
        }
        else if (dir == 3) {
            if (x == minX) return;
            while (x > minX) {
                res.add(matrix[y][x--]);
            }
            maxY = y;
            forward(matrix, ++x, --y, 4);
        }
        else if (dir == 4) {
            if (y == minY) return;
            while (y > minY) {
                res.add(matrix[y--][x]);
            }
            minX = x;
            forward(matrix, ++x, ++y, 1);
        }
    }
}
