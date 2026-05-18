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
    public int diameterOfBinaryTree(TreeNode root) {
        return length(root.right) + length(root.left);
    }

    int length(TreeNode root) {
        if (root == null) return 0;
        
        return 1 + max(length(root.right), length(root.left));
    }

    int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }
}