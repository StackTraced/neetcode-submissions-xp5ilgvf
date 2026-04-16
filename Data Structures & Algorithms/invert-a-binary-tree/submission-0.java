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

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        dfsSwap(root);

        return root;
    }

    private void dfsSwap(TreeNode node) {
        if (node == null) return; // Prevent NPE

        // Swap them
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        dfsSwap(node.left);
        dfsSwap(node.right);
    }
}
