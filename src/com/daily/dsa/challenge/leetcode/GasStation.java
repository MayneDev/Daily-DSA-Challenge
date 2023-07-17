package src.com.daily.dsa.challenge.leetcode;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost = 0;
        int totalFuel = 0;
        for (int x = 0; x < gas.length; x++) {
            totalCost += cost[x];
            totalFuel += gas[x];
        }

        if (totalCost > totalFuel) {
            return -1;
        }

        int start = 0;
        int total = 0;
        for (int x = 0; x < gas.length; x++) {
            total += gas[x] - cost[x];
            if (total < 0) {
                total = 0;
                start = x + 1;
            }
        }
        return start;
    }
}
