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

    static int[] depths;

    public int maxLevelSum(TreeNode root) {
        
        depths = new int[getDepth(root)];

        setDepths(root, 0);

        int max = depths[0];
        int maxIndex = 0;

        for (int i = 0; i < depths.length; i++) {
            if (max < depths[i]) {
                max = depths[i];
                maxIndex = i;
            }
        }
        return maxIndex + 1;
    }

    int getDepth(TreeNode root) {

        if (root == null) return 0;

        return Math.max(getDepth(root.right), getDepth(root.left)) + 1;
    }

    void setDepths(TreeNode root, int depth) {
        if (root == null) return;
        depths[depth] += root.val;

        setDepths(root.left, depth + 1);
        setDepths(root.right, depth + 1);
    }
}