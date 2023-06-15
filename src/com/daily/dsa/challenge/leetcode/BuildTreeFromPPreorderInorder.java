package src.com.daily.dsa.challenge.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromPPreorderInorder {
    Map<Integer, Integer> indices = new HashMap<>();
    int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int x = 0; x < inorder.length; x++) {
            indices.put(inorder[x], x);
        }

        return buildTree(preorder, 0, indices.size() - 1);
    }


    //Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]

    public TreeNode buildTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        TreeNode root = new TreeNode(preorder[preorderIndex]);
        int rootIndex = indices.get(root.val);
        preorderIndex++;

        root.left = buildTree(preorder, left, rootIndex - 1);
        root.right = buildTree(preorder, rootIndex + 1, right);

        return root;
    }
}
