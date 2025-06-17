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
    public int maxDepth(TreeNode root) {
        
        return solveIt(root);
    }

    int solveIt(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right != null) {
            return 1 + Math.max(solveIt(root.left), solveIt(root.right));
        }
        if (root.left != null) return 1 + solveIt(root.left);
        if (root.right != null) return 1 + solveIt(root.right);

        return 1;
    }
}