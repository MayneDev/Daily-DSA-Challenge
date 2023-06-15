package src.com.daily.dsa.challenge.leetcode;

public class MaxPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        return Math.max(getMaxPathSum(root), maxSum);
    }

    public int getMaxPathSum(TreeNode root) {
        int sumLeft = maxPathSum(root.left);
        int sumRight = maxPathSum(root.right);

        maxSum = Math.max(maxSum, sumLeft + sumRight + root.val);

        return Math.max(sumLeft + root.val, sumRight + root.val);
    }
}
