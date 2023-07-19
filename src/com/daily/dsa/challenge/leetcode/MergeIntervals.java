package src.com.daily.dsa.challenge.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int x = 1; x < intervals.length; x++) {
            int[] curr = intervals[x];
            int[] prev = res.get(res.size() - 1);
            if (curr[0] <= prev[1]) {
                prev[1] = curr[1];
            } else {
                res.add(curr);
            }
        }
        int[][] merged = new int[res.size()][2];
        for (int x = 0; x < merged.length; x++) {
            merged[x] = res.get(x);
        }

        return merged;
    }
}
