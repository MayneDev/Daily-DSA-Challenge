package src.com.daily.dsa.challenge.leetcode.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int lastEndTime = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] < lastEndTime) return false;
            else lastEndTime = interval[1];
        }
        return true;
    }
}
