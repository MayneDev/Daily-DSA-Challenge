package src.com.daily.dsa.challenge.leetcode;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (m > 0 && nums[m - 1] > nums[m]) {
                r = m - 1;
            } else if (m < nums.length - 1 && nums[m + 1] > nums[m]) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return l;
    }
}
