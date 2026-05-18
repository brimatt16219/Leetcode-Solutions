/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;

        while (cur != null) {
            if (p.val > cur.val && q.val > cur.val) { // Search right
                cur = cur.right;
            }
            else if (p.val < cur.val && q.val < cur.val) { // Search left
                cur = cur.left; 
            }
            else {
                return cur;
            }
        }
        return root;
    }
}