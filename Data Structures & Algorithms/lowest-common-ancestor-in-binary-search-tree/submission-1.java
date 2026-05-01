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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        
        TreeNode curr = root;
        
        while (curr != null) {
            // If both values are less than curr, move left
            if (curr.val > p.val && curr.val > q.val) {
                curr = curr.left;
            }
            // If both values are greater than curr, move right
            else if (curr.val < p.val && curr.val < q.val) {
                curr = curr.right;
            }

            // Else return current node?
            else {
                return curr;
            }
        }

        return null;
    }
}
