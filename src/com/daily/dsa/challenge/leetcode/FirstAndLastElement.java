package src.com.daily.dsa.challenge.leetcode;

public class FirstAndLastElement {

    public static void main(String[] args) {
        System.out.println(new FirstAndLastElement().searchRange(new int[]{7, 8, 8, 8, 8, 8, 8}, 8).toString());
    }

    /**
     * My attempt
     *
     */
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[]{-1, -1};

        range[0] = binarySearch(nums, target, true);
        if (range[0] != -1) {
            range[1] = binarySearch(nums, target, false);
        }

        return range;

    }

    private int binarySearch(int[] nums, int target, boolean first) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid; // update the answer when nums[mid] == target

                // if we're looking for the first occurrence
                // and the element before mid is target as well, continue searching towards left
                if (first) {
                    end = mid - 1;
                }
                // if we're looking for the last occurrence
                // and the element after mid is target as well, continue searching towards right
                else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }

}
