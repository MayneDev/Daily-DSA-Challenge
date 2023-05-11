package src.com.daily.dsa.challenge.leetcode;

public class SearchInsertPosition {
    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else return mid;

        }
        return left;
    }
}
