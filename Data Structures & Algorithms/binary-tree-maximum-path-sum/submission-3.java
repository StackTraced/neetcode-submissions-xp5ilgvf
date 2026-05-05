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
        // If the value is below 0, we dont want it
        int leftPath = Math.max(0, dfsSearch(root.left));
        int rightPath = Math.max(0, dfsSearch(root.right));

        int sum = root.val + leftPath + rightPath;
        // Now we add the result to see
        bestDistance = Math.max(bestDistance, sum);


        return root.val + Math.max(leftPath, rightPath);
    }
}
