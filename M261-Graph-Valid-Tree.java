class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        if (!dfs(map, visited, -1, 0)) return false;
        for (boolean visit : visited) {
            if (!visit) return false;
        }
        return true;
    }

    private boolean dfs(HashMap<Integer, List<Integer>> map, boolean[] visited, int parent, int node) {
        if (visited[node]) return false;
        List<Integer> nodes = map.get(node);
        visited[node] = true;
        for (int n : nodes) {
            if (n != parent && !dfs(map, visited, node, n)) return false;
        }
        return true;
    }
}
