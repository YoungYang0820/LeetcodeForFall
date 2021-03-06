class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new LinkedList();
        List<int[]> heights = new ArrayList();
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }

        Collections.sort(heights, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            }
        });

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        pq.offer(0);

        int prev = 0;
        for (int[] h : heights) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            }
            else {
                pq.remove(h[1]);
            }

            int curr = pq.peek();
            if (curr != prev) {
                res.add(new int[] {h[0], curr});
                prev = curr;
            }
        }

        return res;
    }
}
