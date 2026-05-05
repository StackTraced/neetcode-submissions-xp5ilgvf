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

    private int bestDistance = 0;

    public int maxPathSum(TreeNode root) {
        bestDistance = root.val;

        dfsSearch(root);

        return bestDistance;
    }

    private int dfsSearch(TreeNode root) {
        if (root == null) return 0;


        // We need to get the left and right path
        int leftPath = dfsSearch(root.left);
        int rightPath = dfsSearch(root.right);


        // We want to return the best value
        int potentialBestSum = selfOrAdd(root, leftPath, rightPath);

        // We have determine the potential best sum for this node only
        bestDistance = Math.max(bestDistance, potentialBestSum);

        // Now, maybe edit the helper method, do we
        // A. Return just the node.val
        // B. Return the node.val + leftPath
        // C. Return the node.val + rightPath?
        int bestResult = root.val;

        int addingLeft = root.val + leftPath;
        int addingRight = root.val + rightPath;
        int bestPath = Math.max(addingLeft, addingRight);

        return Math.max(root.val, bestPath);
    }

    // This is meant to determine at the current node, whats the best sum we can get to return
    private int selfOrAdd(TreeNode root, int leftPath, int rightPath) {
        // Both paths are negative, we don't want to use them
        // We also don't want zero, what does adding zero give us?
        if (leftPath <= 0 && rightPath <= 0) {
            return root.val;
        }

        // If both are positive, we just add them
        if (leftPath > 0 && rightPath > 0) {
            return root.val + leftPath + rightPath;
        }

        // We have determine one of the values is negative
        if (root.val + leftPath > root.val + rightPath) {
            return root.val + leftPath;
        }
        else {
            return root.val + rightPath;
        }
    }
}
