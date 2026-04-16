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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // BFS Syntax
        // Queue<TreeNode> queue = new LinkedList<>();
        // TreeNode item = queue.poll();
        // queue.add(item);
        if (root == null) return false; // Prevent NPE

        // We only want to search if we find the same root
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // We poll the current
            TreeNode check = queue.poll();

            // Check if the value matchs subRoot value
            if (check.val == subRoot.val) {
                // May just chain this
                if (dfsSearch(check, subRoot)) return true;
            }
            if (check.left != null) queue.add(check.left);
            if (check.right != null) queue.add(check.right);
        }

        return false;
    }


    private boolean dfsSearch(TreeNode potential, TreeNode subRoot) {
        // Check if both are null or one is null and such before accessing
        if (potential == null && subRoot == null) return true;

        // Check if one is null
        if (potential == null || subRoot == null) return false;
        
        // Check if the nodes are equal = Both are not null
        if (potential.val != subRoot.val) {
            return false;
        }

        // Both are not null and the values are the same
        return dfsSearch(potential.left, subRoot.left) && dfsSearch(potential.right, subRoot.right);
    }
}
