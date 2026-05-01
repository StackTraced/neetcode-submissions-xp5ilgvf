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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) return result;

        bfs.add(root);

        while (!bfs.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            int size = bfs.size();

            for (int i = 0; i < size; i++) {
                System.out.println("I was ran: size: " + bfs.size());
                TreeNode curr = bfs.poll();
                
                //if (curr != null) 
                list.add(curr.val);

                if (curr.left != null) bfs.add(curr.left);
                if (curr.right != null) bfs.add(curr.right);
            }
            result.add(list);

        }

        return result;
    }
}
