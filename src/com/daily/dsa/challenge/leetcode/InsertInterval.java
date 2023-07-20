package src.com.daily.dsa.challenge.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InsertInterval {
    /**
     * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
     * Output: [[1,5],[6,9]]
     *
     * newInterval = 1,5
     * result = [];
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean inserted = false;

        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0] || inserted) {
                result.add(interval);
            } else {
                if (newInterval[1] < interval[0]) {
                    inserted = true;
                    result.add(newInterval);
                    result.add(interval);
                } else {
                    newInterval[0] = Math.min(newInterval[0], interval[0]);
                    newInterval[1] = Math.max(newInterval[1], interval[1]);
                }
            }
        }

        if(!inserted){
            result.add(newInterval);
        }

        return result.toArray(new int[result.size()][]);
    }
}
