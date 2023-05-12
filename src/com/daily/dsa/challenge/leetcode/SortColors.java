package src.com.daily.dsa.challenge.leetcode;

public class SortColors {

    /**
     * Two pointer approach
     */
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int current = 0;

        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, left, current);
                current++;
                left++;
            }else if (nums[current] == 2) {
                swap(nums, right, current);
                right--;
            }else
            {current++;}
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Count ones and zeros
     */
    public void sortColorsCounting(int[] nums) {
        int zeros = 0;
        int ones = 0;
        for (int x : nums) {
            if (x == 0) zeros++;
            if (x == 1) ones++;
        }

        for (int x = 0; x < nums.length; x++) {
            if (zeros > 0) {
                nums[x] = 0;
                zeros--;
            } else if (ones > 0) {
                nums[x] = 1;
                ones--;
            } else {
                nums[x] = 2;
            }
        }
    }
}
