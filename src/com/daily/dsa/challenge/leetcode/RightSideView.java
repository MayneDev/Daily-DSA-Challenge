package src.com.daily.dsa.challenge.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {

        //For every level, we can only see the last element
        //We do a level order L->R traversal, the only pick the last element in each level
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        int element = 0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            while (size > 0) {
                TreeNode curr = nodes.poll();
                element = curr.val;

                if (curr.left != null) nodes.offer(curr.left);
                if (curr.right != null) nodes.offer(curr.right);
                size--;
            }
            result.add(element);
        }

        return result;

    }
}
