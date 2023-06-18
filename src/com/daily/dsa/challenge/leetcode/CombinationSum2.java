package src.com.daily.dsa.challenge.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> curr, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0) return;

        for (int x = index; x < candidates.length; x++) {
            if (x > index && candidates[x] == candidates[x - 1]) continue;
            curr.add(candidates[x]);
            backtrack(candidates, target - candidates[x], res, curr, x + 1);
            curr.remove(curr.size() - 1);

        }
    }
}
