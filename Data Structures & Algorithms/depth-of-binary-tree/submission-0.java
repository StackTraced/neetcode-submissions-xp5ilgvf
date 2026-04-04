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
    // May be a DFS angle, since we can count?
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Can guarantee no null
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        int maxDepth = 0;

        int sizeOfQueue;

        while(!bfs.isEmpty()) {

            sizeOfQueue = bfs.size();

            for (int i = 0; i < sizeOfQueue; i++) {
                TreeNode curr = bfs.poll();

                // add the next level
                if (curr.left != null) {
                    bfs.add(curr.left);
                }

                if (curr.right != null) {
                    bfs.add(curr.right);
                }
            }
            maxDepth++;
        }

        return maxDepth;
    }
}
