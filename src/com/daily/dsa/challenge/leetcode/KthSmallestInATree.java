package src.com.daily.dsa.challenge.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestInATree {
    public int kthSmallest(TreeNode root, int k) {
        return dfs(root).get(k-1);
    }

    private List<Integer> dfs(TreeNode root){
        if(root == null) return new ArrayList<Integer>();

        List<Integer> res =  new ArrayList<Integer>();
        res.addAll(dfs(root.left));
        res.add(root.val);
        res.addAll(dfs(root.right));

        return res;
    }
}
