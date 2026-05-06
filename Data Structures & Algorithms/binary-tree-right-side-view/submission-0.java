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
    public List<Integer> rightSideView(TreeNode root) {
        // If the root is null, we can't access it
        if (root == null) return new ArrayList<>();


        Queue<TreeNode> bfs = new ArrayDeque<>();

        // Stack to keep track of each level
        Stack<TreeNode> stack = new Stack<>();

        List<Integer> result = new ArrayList<>();
        

        bfs.add(root);

        while (!bfs.isEmpty()) {
            
            // We already added root, now we get the size of this level
            int sizeOfQueue = bfs.size();

            TreeNode lastLevel = null;
            
            for (int i = 0; i < sizeOfQueue; i++) {
                lastLevel = bfs.poll();

                if (lastLevel.left != null) {
                    bfs.add(lastLevel.left);
                }

                if (lastLevel.right != null) {
                    bfs.add(lastLevel.right);
                }

            }
            
            result.add(lastLevel.val);
        }

        return result;
    }
}
