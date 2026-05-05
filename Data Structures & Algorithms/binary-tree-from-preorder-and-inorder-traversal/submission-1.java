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

    private HashMap<Integer, Integer> getIndex;
    private int[] preorder;
    private int[] inorder;
    private int pointer = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Dont want to pass these, making global
        this.getIndex = new HashMap<>();
        this.preorder = preorder;
        this.inorder = inorder;


        // Find the index of the inorder
        for (int i = 0; i < inorder.length; i++) {
            getIndex.put(inorder[i], i);
        }
        
        return buildInnerTree(0, preorder.length - 1);   
    }

    private TreeNode buildInnerTree(int lowerBound, int upperBound) {
        if (lowerBound > upperBound) {
            return null;
        }

        
        int rootVal = preorder[pointer];
        
        TreeNode root = new TreeNode(preorder[pointer]);
        int mid = getIndex.get(preorder[pointer]);
        pointer++;
        
    
        // Build the left
        root.left = buildInnerTree(lowerBound, mid - 1);
        root.right = buildInnerTree(mid + 1, upperBound);


        return root;
    }
}
