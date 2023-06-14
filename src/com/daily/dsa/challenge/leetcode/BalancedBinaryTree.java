package src.com.daily.dsa.challenge.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BalancedBinaryTree {


    public boolean isBalanced(TreeNode root) {
        //DFS
        //Get height of left vs right
        //return abs(left - right) < 2

        if (root == null) return true;
        return dfs(root, new HashMap<TreeNode, Integer>());

    }

    private boolean dfs(TreeNode root, Map<TreeNode, Integer> heights) {
        if (root == null) {
            heights.put(null, 0);
            return true;
        }
        boolean leftBalanced = dfs(root.left, heights);
        boolean rightBalanced = dfs(root.right, heights);

        heights.put(root, Math.max(heights.get(root.left), heights.get(root.right)) + 1);
        return leftBalanced && rightBalanced && Math.abs(heights.get(root.left) - heights.get(root.right)) < 2;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
