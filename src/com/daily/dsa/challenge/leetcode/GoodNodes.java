package src.com.daily.dsa.challenge.leetcode;

public class GoodNodes {
    public int goodNodes(TreeNode root) {
        return goodNodes(root,root.val);
    }

    private int goodNodes(TreeNode root, int max){
        if(root == null) return 0;

        return goodNodes(root.left, Math.max(max,root.val))
                + goodNodes(root.right, Math.max(max,root.val)) + (root.val >= max ? 1 :0);
    }
}
