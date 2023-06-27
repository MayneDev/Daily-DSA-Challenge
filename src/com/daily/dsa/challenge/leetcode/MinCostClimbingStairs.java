package src.com.daily.dsa.challenge.leetcode;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int x = 2;
        while (x < cost.length) {
            cost[x] = Math.min(cost[x - 2], cost[x - 1]) + cost[x];
            x++;
        }
        return Math.min(cost[x - 1], cost[x - 2]);
    }
}
