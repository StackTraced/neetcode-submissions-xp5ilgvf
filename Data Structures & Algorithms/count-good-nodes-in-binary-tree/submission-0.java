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

    private int count = 0;


    public int goodNodes(TreeNode root) {
        if (root == null) return count;

        // We are guaranteed a node now
        dfs(root, Integer.MIN_VALUE);
        return count;    
    }

    // anchor is the highest value above it
    private void dfs(TreeNode root, int anchor) {
        if (root == null) return; // We dont deal with null
        
        // Here we have a non-null TreeNode,
        // Check its value
        int localValue = root.val;

        System.out.println("The current node is: " + root.val + " and anchor is " + anchor);

        // Is the current node value GREATER than the anchor?
        if (localValue >= anchor) {
            count++;
        }

        anchor = Math.max(anchor, localValue);

        // Now we repeat
        dfs(root.left, anchor);
        dfs(root.right, anchor);
    }

    
}
