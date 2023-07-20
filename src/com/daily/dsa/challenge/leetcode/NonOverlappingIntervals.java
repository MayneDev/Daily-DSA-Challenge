package src.com.daily.dsa.challenge.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    //[[1,3],[1,2],[2,3],[3,4],]
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int deletes = 0;
        int last = intervals[0][1];

        for (int x = 1; x < intervals.length; x++) {
            if (intervals[x][0] < last) {
                deletes++;
                last = Math.min(last, intervals[x][1]);
            } else {
                last = intervals[x][1];
            }
        }

        return deletes;
    }
}
