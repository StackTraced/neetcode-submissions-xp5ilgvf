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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Not waste time traversing if both are null
        if (p == null && q == null) {
            return true;
        }

        // If one is null and the other isn't, don't waste time
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        // Guaratneee to not have null values

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
