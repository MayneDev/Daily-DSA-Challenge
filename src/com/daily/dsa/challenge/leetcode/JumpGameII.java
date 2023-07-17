package src.com.daily.dsa.challenge.leetcode;

public class JumpGameII {
    public int jump(int[] nums) {
        int jumps = 0;
        int target = nums.length - 1;

        while (target > 0) {
            int temp = target;
            for (int j = target; j >= 0; j--) {
                if (nums[j] + j >= target) {
                    temp = j;
                }
            }
            target = temp;
            jumps++;
        }
        return jumps;
    }
}
