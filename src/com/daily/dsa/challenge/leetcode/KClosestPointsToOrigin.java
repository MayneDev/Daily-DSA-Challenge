package src.com.daily.dsa.challenge.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));

        for (int x = 0; x < points.length; x++) {
            //Calculate distance
            int distance = points[x][0] * points[x][0] + points[x][1] * points[x][1]; //Ignore sqr
            heap.add(new int[]{distance, x});
        }

        int[][] res = new int[k][2];
        while (k > 0) {
            res[k - 1] = points[heap.remove()[1]];
            k--;
        }

        return res;
    }
}
