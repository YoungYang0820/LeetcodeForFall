public class Solution {
    public boolean isReflected(int[][] points) {
        if (points == null) {
            return false;
        }

        Arrays.sort(points, new ArrComparator());

        int[][] reflectedPoints = new int[points.length][2];
        for (int i = 0; i < reflectedPoints.length; i++) {
            reflectedPoints[i][0] = points[0][0] + points[reflectedPoints.length-1][0] - points[i][0];
            reflectedPoints[i][1] = points[i][1];
        }

        Arrays.sort(reflectedPoints, new ArrComparator());

        for (int i = 0; i < reflectedPoints.length; i++) {
            if (reflectedPoints[i][0] != points[i][0] ||
                reflectedPoints[i][1] != points[i][1]) {
                    return false;
                }
        }
        return true;
    }

    public class ArrComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int b[]) {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
        return Integer.compare(a[0], b[0]);
        }
    }
}
