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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        Map<Integer, Integer> inIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inIndex.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1,
                      inorder,  0, inorder.length  - 1,
                      inIndex);
    }

    TreeNode helper(int[] pre, int preL, int preR, 
                    int[] in, int inL, int inR,
                    Map<Integer,Integer> inIndex) {
        
        if (preL > preR) {
            return null;
        }
        int rootVal = pre[preL];
        TreeNode root = new TreeNode(rootVal);

        int mid = inIndex.get(rootVal);
        int leftSize = mid - inL;

        root.left = helper(pre, preL + 1, preL + leftSize,
                            in, inL, mid - 1,
                            inIndex);

        root.right = helper(pre, preL + leftSize + 1, preR,
                            in, mid + 1, inR,
                            inIndex);
        return root;
    }
}