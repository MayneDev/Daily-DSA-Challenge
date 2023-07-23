package src.com.daily.dsa.challenge.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {
    Map<Integer, Integer> memo = new HashMap<>();

    public int deleteAndEarn(int[] nums) {
        int maxValue = 0;
        for (int i : nums)
            maxValue = Math.max(maxValue, i);

        int[] data = new int[maxValue + 1];
        for (int num : nums)
            data[num] += num;

        return dfs(data, 0);
    }

    private int dfs(int[] nums, int idx) {
        if (idx >= nums.length) {
            return 0;
        }

        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }

        int pick = nums[idx] + dfs(nums, idx + 2);
        int notPick = dfs(nums, idx + 1);
        memo.put(idx, Math.max(pick, notPick));
        return memo.get(idx);
    }
}
