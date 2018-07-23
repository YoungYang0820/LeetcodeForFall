/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int l = intervals.length;
        int[] start = new int[l];
        int[] end = new int[l];
        for (int i = 0; i < l; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int numRooms = 0;
        int available = 0;
        int s = 0, e = 0;
        while (s < l) {
            if (start[s] < end[e]) {
                if (available == 0) numRooms++;
                else available--;
                s++;
            }
            else {
                available++;
                e++;
            }
        }
        return numRooms;
    }
}
