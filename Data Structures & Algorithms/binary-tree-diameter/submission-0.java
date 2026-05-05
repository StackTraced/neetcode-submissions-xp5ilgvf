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

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root, 0);

        return bestDistance;
    }

    // We want to return the best of the two paths, but also check the best
    private int dfs(TreeNode root, int distance) {
        if (root == null) {
            return 0;
        }


        int leftNode = dfs(root.left, distance);
        int rightNode = dfs(root.right, distance);

        System.out.println("At node: " + root.val + " the left is " + leftNode + " and the right is: " + rightNode);

        bestDistance = Math.max(leftNode + rightNode, bestDistance);

        return Math.max(leftNode, rightNode) + 1;
    }
}
