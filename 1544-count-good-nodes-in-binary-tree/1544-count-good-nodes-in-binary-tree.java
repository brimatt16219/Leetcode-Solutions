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

    static int count = 0;

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    int dfs(TreeNode node, int max) {
        if (node == null) return 0;

        int count = node.val >= max ? 1 : 0;
        max = Math.max(max, node.val);

        count += dfs(node.left, max);
        count += dfs(node.right, max);
        
        return count;
    }
}