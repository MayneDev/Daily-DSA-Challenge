package src.com.daily.dsa.challenge.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int options = Integer.MAX_VALUE;
        boolean canChange = false;
        for (int coin : coins) {
            int currWays = Math.min(options, coinChange(coins, amount - coin));
            if (currWays >= 0) {
                canChange = true;
                options = Math.min(options, currWays);
            }
        }

        options = canChange ? options + 1 : -1;
        memo.put(amount, options);
        return options;
    }
}
