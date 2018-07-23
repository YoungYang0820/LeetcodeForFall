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
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.start == i2.start) return i2.end - i1.end;
                return i1.start - i2.start;
            }
        });
        int prevS = intervals[0].start;
        int prevE = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start == prevS) return false;
            if (intervals[i].start < prevE) return false;
            prevS = intervals[i].start;
            prevE = Math.max(intervals[i].end, prevE);
        }
        return true;
    }
}
