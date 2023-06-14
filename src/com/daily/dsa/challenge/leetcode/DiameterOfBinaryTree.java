package src.com.daily.dsa.challenge.leetcode;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        return Math.max(dfs(root.left) + dfs(root.right),
                Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;
        return Math.max(dfs(root.right), dfs(root.left)) + 1;
    }
}
