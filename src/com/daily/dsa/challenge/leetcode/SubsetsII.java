package src.com.daily.dsa.challenge.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), res, 0);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> curr, List<List<Integer>> res, int index) {
        res.add(new ArrayList<>(curr));

        for (int x = index; x < nums.length; x++) {
            if (x != index && nums[x] == nums[x - 1]) continue;

            curr.add(nums[x]);
            backtrack(nums, curr, res, x + 1);
            curr.remove(curr.size() - 1);
        }

    }
}
