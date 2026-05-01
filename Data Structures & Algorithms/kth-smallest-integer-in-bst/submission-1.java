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

    private int globalVar = 0;
    private TreeNode result = new TreeNode(-1);
    private boolean isFound = false;
    private int target = 0;

    public int kthSmallest(TreeNode root, int k) {
        this.target = k;
        dfsFixed(root);

        return result.val;
    }

    private void dfsFixed (TreeNode root) {
        if (root == null) return;

        dfsFixed(root.left);
        
        // Now we are at the node, we increment the value by 1
        globalVar += 1; // This is currently the smallest node

        if (globalVar == target && !isFound) {
            result = root;
        }

        dfsFixed(root.right);

        
    }

}
