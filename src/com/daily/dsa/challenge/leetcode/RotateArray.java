package src.com.daily.dsa.challenge.leetcode;

public class RotateArray {

    //Possible approached
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        new RotateArray().rotate(nums, 3);
    }

    public void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }


    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotateBrute(int[] nums, int k) {
        while (k > 0) {
            int temp = nums[0];
            for (int x = 1; x < nums.length; x++) {
                int temp1 = nums[x];
                nums[x] = temp;
                temp = temp1;
            }
            nums[0] = temp;
            k--;
        }
    }

}
