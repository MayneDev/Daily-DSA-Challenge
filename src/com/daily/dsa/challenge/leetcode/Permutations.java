package src.com.daily.dsa.challenge.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for(int x: nums){
            numsList.add(x);
        }

        List<List<Integer>> res = new ArrayList<>();
        backtrack(numsList, res, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(List<Integer> numsList, List<List<Integer>> res, List<Integer> curr ){
        if(numsList.size() == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        int len = numsList.size();

        for(int i=0; i < len; i++){
            int x = numsList.get(i);
            curr.add(x);

            List<Integer> newList = new ArrayList<>(numsList);
            newList.remove(i);
            backtrack(newList, res, curr);
            curr.remove(curr.size() - 1);
        }
    }

}
