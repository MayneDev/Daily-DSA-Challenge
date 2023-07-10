package src.com.daily.dsa.challenge.leetcode;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int result = 0;
        for (int x = 0; x <= nums.length; x++) {
            result ^= x;
        }

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
