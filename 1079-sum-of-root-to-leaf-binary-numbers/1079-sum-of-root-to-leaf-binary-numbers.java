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
    public static ArrayList<String> list = new ArrayList<String>();
    
    public int sumRootToLeaf(TreeNode root) {
        list.clear();
        solveIt(root, "");
        System.out.println(list);
        
        int sum = 0;
        for (int i = 0; i < list.size(); i++)
        {
            sum += Integer.parseInt(list.get(i), 2);
        }
        return sum;
    }
    
    void solveIt(TreeNode root, String s)
    {
        System.out.println("rootval is " + root.val);
        
        s = s.concat(Integer.toString(root.val));
        System.out.println("s is now : " + s);
        if (root.left != null)
        {
            solveIt(root.left, s);
        }
        if (root.right != null)
        {
            solveIt(root.right, s);
        }
        s.concat(Integer.toString(root.val));
        
        if ((root.left == null) && (root.right == null)) list.add(s);
    }
}