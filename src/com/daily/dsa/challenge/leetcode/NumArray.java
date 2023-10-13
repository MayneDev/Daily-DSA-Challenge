package src.com.daily.dsa.challenge.leetcode;

public class NumArray {

    private  int[] nums;
    private  int[] numSum;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.numSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++){
            numSum[i + 1] = numSum[i] + nums[i];
        }
    }

    public void update(int index, int val) {
        nums[index] = val;

        //Update sums
        for (int i = index; i < numSum.length; i++){
            numSum[i + 1] = numSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return numSum[right + 1] - numSum[left + 1];
    }
}
