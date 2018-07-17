class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        for (int[] course : prerequisites) {
            graph[course[1]].add(course[0]);
        }

        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visited, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int index, boolean[] visited, ArrayList[] graph) {
        if (visited[index]) return false;
        else visited[index] = true;

        for (int i = 0; i < graph[index].size(); i++) {
            if (!dfs((int) graph[index].get(i), visited, graph)) return false;
        }
        visited[index] = false;
        return true;
    }
}
