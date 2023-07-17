package src.com.daily.dsa.challenge.leetcode;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int target = nums[nums.length - 1];
        for (int x = nums.length - 1; x >= 0; x--) {
            if (nums[x] + x >= target) {
                target = x;
            }
        }
        return target == 0;
    }

    public boolean canJump1(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        int n = nums.length - 2;


        while (n >= 0) {
            int x = nums[n];
            while (x > 0) {
                if (n + x < nums.length && dp[n + x]) {
                    dp[n] = true;
                    break;
                }
                x--;
            }
            n--;
        }

        return dp[0];
    }
}
