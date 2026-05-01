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
    public boolean isValidBST(TreeNode root) {
        return bstValidator(null, root, null); 
    }

    private boolean bstValidator(Integer upperBound, TreeNode root, Integer lowerBound) {
        // First check if root is null, before attempting to grab
        if (root == null) return true;

        if (upperBound != null && root.val >= upperBound) return false;
        if (lowerBound != null && root.val <= lowerBound) return false;

        // Now that we verified it satifies both
        return bstValidator(root.val, root.left, lowerBound) && bstValidator(upperBound, root.right, root.val);
    }
}
