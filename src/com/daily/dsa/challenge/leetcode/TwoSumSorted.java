package src.com.daily.dsa.challenge.leetcode;

public class TwoSumSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 1;
        int right = numbers.length;

        while (left < right) {
            int sum = numbers[left - 1] + numbers[right - 1];

            if (sum == target) return new int[]{left, right};

            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return res;
    }
}
