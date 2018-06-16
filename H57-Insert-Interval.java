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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<>();
        for (Interval interval : intervals) {
            if (newInterval == null || newInterval.start > interval.end) {
                res.add(interval);
            }
            else if (newInterval.end < interval.start) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            }
            else {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        if (newInterval != null) {
            res.add(newInterval);
        }
        return res;
    }
}
