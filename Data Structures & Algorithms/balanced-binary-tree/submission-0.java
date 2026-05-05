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

    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        // Pass two
        dfs(root);
        return isBalanced;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        // We check both sides again
        int leftSideHeight = dfs(root.left) + 1;
        int rightSideHeight = dfs(root.right) + 1;

        // We found a mistmatch
        if (Math.abs(leftSideHeight - rightSideHeight) > 1) {
            isBalanced = false;
        }

        return Math.max(leftSideHeight, rightSideHeight);
    }

    // Subtact the values 
}
