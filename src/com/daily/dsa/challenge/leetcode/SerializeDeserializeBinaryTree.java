package src.com.daily.dsa.challenge.leetcode;

public class SerializeDeserializeBinaryTree {
    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //Use preorder traversal
        if (root == null) return "N";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(data.split(","));
    }

    public TreeNode deserialize(String[] data) {
        if (data[index].equals("N")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(data[index]));
        index++;

        root.left = deserialize(data);
        index++;

        root.right = deserialize(data);

        return root;
    }
}
