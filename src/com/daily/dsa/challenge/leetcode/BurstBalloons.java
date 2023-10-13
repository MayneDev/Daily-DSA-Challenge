package src.com.daily.dsa.challenge.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BurstBalloons {
    Map<String, Integer> memo = new HashMap<>();

    public int maxCoins(int[] nums) {
        //1,[3,1,5,8],1
        return countCoins(nums, 0, nums.length - 1);
    }

    private int countCoins(int[] nums, int l, int r) {
        String key = l + ":" + r;
        if (l > r) {
            return 0;
        }
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int coins = 0;
        for (int i = l; i <= r; i++) {

            int curr = getCoins(nums, l - 1) * getCoins(nums, i) * getCoins(nums, r + 1);

            curr += countCoins(nums, l, i - 1);
            curr += countCoins(nums, i + 1, r);

            coins = Math.max(coins, curr);
        }
        memo.put(key, coins);
        return coins;
    }

    private int getCoins(int[] nums, int idx) {
        if (idx < 0 || idx == nums.length) return 1;
        return nums[idx];
    }
}
