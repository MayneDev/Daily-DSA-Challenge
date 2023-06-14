package src.com.daily.dsa.challenge.leetcode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        TreeNode tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tmp;

        return root;
    }
}
