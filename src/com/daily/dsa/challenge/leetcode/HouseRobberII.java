package src.com.daily.dsa.challenge.leetcode;

public class HouseRobberII {
    public int rob(int[] nums) {
        //return max stash from robbing from 0 to n-1 or 1 to n
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] numsCopy = new int[nums.length];
        System.arraycopy(nums, 0, numsCopy, 1, n);

        numsCopy[0] = 0;
        nums[n - 1] = 0;

        helper(nums);
        helper(numsCopy);
        return Math.max(nums[n - 1], numsCopy[n - 1]);
    }

    private void helper(int[] nums) {
        if (nums.length > 2) {
            nums[1] = Math.max(nums[0], nums[1]);
        }

        int x = 2;
        while (x < nums.length) {
            nums[x] = Math.max(nums[x - 1], nums[x] + nums[x - 2]);
            x++;
        }
    }
}
