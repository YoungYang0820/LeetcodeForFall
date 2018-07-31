class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int m = grid.length, n = grid[0].length;
        int[][] visitDist = new int[m][n];
        int[][] visitNum = new int[m][n];
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    num++;
                    int dist = 0;
                    Queue<int[]> queue = new LinkedList();
                    boolean[][] visited = new boolean[m][n];
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] node = queue.poll();
                            int x = node[0];
                            int y = node[1];

                            visitDist[x][y] += dist;
                            visitNum[x][y]++;
                            if (x > 0 && grid[x-1][y] == 0 && !visited[x-1][y]) {
                                queue.offer(new int[] {x-1, y});
                                visited[x-1][y] = true;
                            }
                            if (x < m - 1 && grid[x+1][y] == 0 && !visited[x+1][y]) {
                                queue.offer(new int[] {x+1, y});
                                visited[x+1][y] = true;
                            }
                            if (y > 0 && grid[x][y-1] == 0 && !visited[x][y-1]) {
                                queue.offer(new int[] {x, y-1});
                                visited[x][y-1] = true;
                            }
                            if (y < n - 1 && grid[x][y+1] == 0 && !visited[x][y+1]) {
                                queue.offer(new int[] {x, y+1});
                                visited[x][y+1] = true;
                            }
                        }
                        dist++;
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && visitNum[i][j] == num && visitDist[i][j] < result) {
                    result = visitDist[i][j];
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
