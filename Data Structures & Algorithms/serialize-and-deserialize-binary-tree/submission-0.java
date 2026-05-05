/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    private StringBuilder sb;

    private int pointer;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        sb = new StringBuilder();
    
        dfs(root);
    
        
        return sb.toString();
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");
        
        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        
        pointer = 0;

        String[] split = data.split(",");
        
        TreeNode rebuilt = rebuilt(split);

        return rebuilt;
    }

    private TreeNode rebuilt(String[] split) {
        if (split[pointer].equals("N")) return null;

        // We build the node
        TreeNode root = new TreeNode(Integer.parseInt(split[pointer++]));
        
        root.left = rebuilt(split);
        pointer++;
        root.right = rebuilt(split);

        return root;
    }
}
