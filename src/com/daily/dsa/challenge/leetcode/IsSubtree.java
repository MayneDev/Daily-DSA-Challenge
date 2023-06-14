package src.com.daily.dsa.challenge.leetcode;

public class IsSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        return isEqual(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isEqual(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true; //Base case
        if (root == null || subRoot == null) return false; //Base case

        return root.val == subRoot.val
                && isEqual(root.left, subRoot.left)
                && isEqual(root.right, subRoot.right);
    }
}
