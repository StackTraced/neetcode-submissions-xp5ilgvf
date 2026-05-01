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
    public int kthSmallest(TreeNode root, int k) {
        // Get it to work first, then fix
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Default already a min heap

        dfsAdd(minHeap, root);

        for (int i = 1; i < k; i++) {
            minHeap.poll();
        }

        return minHeap.poll();

    }

    private void dfsAdd(PriorityQueue<Integer> minHeap, TreeNode root) {
        if (root == null) return;

        minHeap.add(root.val);

        dfsAdd(minHeap, root.left);
        dfsAdd(minHeap, root.right);
    }
}
