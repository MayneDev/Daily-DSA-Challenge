package src.com.daily.dsa.challenge.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, new ArrayList<>(), 0);
        return result;
    }

    private int traverse(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return level;
        }

        int left = traverse(root.left, result, level);
        int right = traverse(root.right, result, level);

        int currentLevel = Math.max(left, right);

        if (result.size() <= currentLevel) {
            result.add(new ArrayList<>());
        }
        result.get(Math.max(left, right)).add(root.val);
        return level + 1;
    }
}
