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
        
        Queue<TreeNode> bfs = new LinkedList<>();

        bfs.add(root);

        
        while (!bfs.isEmpty()) {
            TreeNode curr = bfs.poll();

            // If both values are less than curr, move left
            if (curr.val > p.val && curr.val > q.val) {
                bfs.add(curr.left);
            }
            // If both values are greater than curr, move right
            else if (curr.val < p.val && curr.val < q.val) {
                bfs.add(curr.right);
            }

            // Else return current node?
            else {
                return curr;
            }
        }

        return null;
    }
}
