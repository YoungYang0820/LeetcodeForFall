class Solution {
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;
    private int[][] res;
    public int[][] generateMatrix(int n) {
        minX = -1;
        minY = -1;
        maxX = n;
        maxY = n;
        res = new int[n][n];
        forward(1, 0, 0, 1);
        return res;
    }

    private void forward(int start, int x, int y, int dir) {
        if (dir == 1) {
            if (x == maxX) return;
            while (x < maxX) {
                res[y][x++] = start++;
            }
            minY = y;
            forward(start, --x, ++y, 2);
        }
        else if (dir == 2) {
            if (y == maxY) return;
            while (y < maxY) {
                res[y++][x] = start++;
            }
            maxX = x;
            forward(start, --x, --y, 3);
        }
        else if (dir == 3) {
            if (x == minX) return;
            while (x > minX) {
                res[y][x--] = start++;
            }
            maxY = y;
            forward(start, ++x, --y, 4);
        }
        else if (dir == 4) {
            if (y == minY) return;
            while (y > minY) {
                res[y--][x] = start++;
            }
            minX = x;
            forward(start, ++x, ++y, 1);
        }
    }
}
