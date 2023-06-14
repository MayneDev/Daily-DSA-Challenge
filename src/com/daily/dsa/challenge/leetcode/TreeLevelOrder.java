package src.com.daily.dsa.challenge.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = nodes.size();
            while (size > 0) {
                TreeNode curr = nodes.poll();
                level.add(curr.val);
                if (curr.left != null) nodes.add(curr.left);
                if (curr.right != null) nodes.add(curr.right);
                size--;
            }
            result.add(level);
        }
        return result;

    }


}
