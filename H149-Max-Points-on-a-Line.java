/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            int repeatOrigin = 0;
            int tempMax = 0;
            HashMap<Double, Integer> slopes = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (equal(points[i], points[j]))
                    repeatOrigin++;
                else {
                    double slope = slopeTo(points[i], points[j]);
                    int temp = slopes.getOrDefault(slope, 0) + 1;
                    slopes.put(slope, temp);
                    tempMax = Math.max(tempMax, temp);
                }
            }
            max = Math.max(tempMax + repeatOrigin, max);
        }
        return max;
    }

    private double slopeTo(Point a, Point b) {
         if (a.y == b.y) return Double.MAX_VALUE;
         return (double)(b.x - a.x)/(b.y - a.y);
    }

    private boolean equal(Point a, Point b) {
         if (a.x == b.x && a.y == b.y) return true;
         return false;
    }
}
