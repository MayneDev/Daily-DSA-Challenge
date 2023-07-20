package src.com.daily.dsa.challenge.leetcode.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public static void main(String[] args) {
        System.out.println(new MeetingRoomsII().minMeetingRooms(new int[][]{
                {1, 2},
                {4, 5},
                {7, 8}
        }));
        System.out.println(new MeetingRoomsII().minMeetingRooms(new int[][]{
                {0, 30},
                {5, 10},
                {7, 8}
        }));
        System.out.println(new MeetingRoomsII().minMeetingRooms(new int[][]{
                {0, 4},
                {5, 10},
                {15, 20}
        }));
    }

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        rooms.offer(intervals[0][1]);

        for (int x = 1; x < intervals.length; x++) {
            if (intervals[x][0] >= rooms.peek()) {
                rooms.poll();
            }
            rooms.add(intervals[x][1]);
        }

        return rooms.size();
    }
}
