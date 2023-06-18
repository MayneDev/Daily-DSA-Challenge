package src.com.daily.dsa.challenge.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void subsets(int[] nums, int index, List<List<Integer>> subsets, List<Integer> curr) {
        subsets.add(new ArrayList<>(curr));

        for (int x = index; x < nums.length; x++) {
            curr.add(nums[x]);
            subsets(nums, x + 1, subsets, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
