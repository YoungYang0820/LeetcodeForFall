class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        int[] preCount = new int[numCourses];
        int[] res= new int[numCourses];
        for (int[] pre : prerequisites) {
            preCount[pre[0]]++;
            graph[pre[1]].add(pre[0]);
        }
        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (preCount[i] == 0) q.add(i);
        }

        int index = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            res[index++] = course;
            ArrayList<Integer> list = graph[course];
            for (int i : list) {
                preCount[i]--;
                if (preCount[i] == 0) q.add(i);
            }
        }
        return index == numCourses ? res : new int[0];
    }
}
