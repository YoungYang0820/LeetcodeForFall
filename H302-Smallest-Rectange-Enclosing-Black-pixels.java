class Solution {
    private int minX, minY, maxX, maxY;
    public int minArea(char[][] image, int x, int y) {
        minX = Integer.MAX_VALUE;
        minY = Integer.MAX_VALUE;
        maxX = 0;
        maxY = 0;
        dfs(image, x, y, new boolean[image.length][image[0].length]);
        return (maxX - minX + 1) * (maxY - minY + 1);
    }

    private void dfs(char[][] image, int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != '1' || visited[x][y]) return;
        minX = Math.min(x, minX);
        minY = Math.min(y, minY);
        maxX = Math.max(x, maxX);
        maxY = Math.max(y, maxY);
        visited[x][y] = true;
        dfs(image, x + 1, y, visited);
        dfs(image, x - 1, y, visited);
        dfs(image, x, y + 1, visited);
        dfs(image, x, y - 1, visited);
    }
}
