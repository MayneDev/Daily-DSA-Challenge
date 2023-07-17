package src.com.daily.dsa.challenge.leetcode;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length - 1;
        int currSum = nums[n];
        int maxSum = nums[n];
        for (int x = n - 1; x >= 0; x--) {
            currSum = Math.max(nums[x], nums[x] + currSum);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
