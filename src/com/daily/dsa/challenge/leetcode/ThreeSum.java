package src.com.daily.dsa.challenge.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int x = 0; x < nums.length; x++) {
            if (x == 0 || nums[x] != nums[x - 1]) {
                List<List<Integer>> twoSum = twoSum(nums, nums[x], x + 1);
                if (!twoSum.isEmpty()) {
                    res.addAll(twoSum);
                }
            }
        }

        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int num, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right] + num;
            if (sum == 0) {
                List<Integer> tuple = new ArrayList<>();
                tuple.add(num);
                tuple.add(nums[left]);
                tuple.add(nums[right]);
                res.add(tuple);

                left++;
                while (nums[left] == nums[left - 1] && left < right)
                    left++;
            } else if (sum > 0) right--;
            else left++;
        }
        return res;
    }
}
