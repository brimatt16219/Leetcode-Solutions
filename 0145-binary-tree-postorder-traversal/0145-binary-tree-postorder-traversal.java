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
    public static ArrayList<Integer> list = new ArrayList<Integer>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
        list.clear();
        print(root);
        return list;
    }
    
    public void print(TreeNode root)
    {
        if (root != null)
        {
            
            
            if (root.left != null)
            {
                print(root.left);
            }
            if (root.right != null)
            {
                print(root.right);
            }
            list.add(root.val);
        }
        
    }
}