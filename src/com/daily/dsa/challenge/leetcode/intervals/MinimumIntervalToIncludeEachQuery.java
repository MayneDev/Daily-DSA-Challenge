package src.com.daily.dsa.challenge.leetcode.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumIntervalToIncludeEachQuery {
    public int[] minInterval(int[][] intervals, int[] queries) {

        //Sort intervals with starting time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        //Sort queries tracking the position of each element
        PriorityQueue<int[]> sortedQueries = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < queries.length; i++) {
            sortedQueries.offer(new int[]{queries[i], i});
        }

        PriorityQueue<int[]> intervalQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int[] result = new int[queries.length];
        int currentInterval = 0;

        while (!sortedQueries.isEmpty()) {
            int[] curr = sortedQueries.poll();
            int query = curr[0];

            //First remove intervals from intervalQueue where query does not belong
            while (!intervalQueue.isEmpty() && intervalQueue.peek()[1] < query) {
                intervalQueue.poll();
            }

            //Check intervals where query belong
            while (currentInterval < intervals.length && intervals[currentInterval][0] <= query) {
                if (intervals[currentInterval][1] >= query)
                    intervalQueue.offer(new int[]{intervals[currentInterval][1] - intervals[currentInterval][0] + 1, intervals[currentInterval][1]});
                currentInterval++;
            }

            if (intervalQueue.isEmpty()) {
                result[curr[1]] = -1;
            } else {
                result[curr[1]] = intervalQueue.peek()[0];
            }
        }

        return result;
    }
}
