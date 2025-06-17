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

    static ArrayList<Integer> arr = new ArrayList<Integer>();
    static ArrayList<Integer> arr2 = new ArrayList<Integer>();


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        arr.clear();
        arr2.clear();

        solveIt(root1);
        solveIt2(root2);
        if (arr.size() != arr2.size()) return false;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != arr2.get(i)) return false;
        }

        return true;
    }

    void solveIt(TreeNode root) {

        if (root.left == null && root.right == null) {
            System.out.println(root.val);
            arr.add(root.val);
        }
        
        if (root.left != null) solveIt(root.left);
        if (root.right != null) solveIt(root.right);
    }
    void solveIt2(TreeNode root) {

        if (root.left == null && root.right == null) {
            System.out.println(root.val);
            arr2.add(root.val);
        }
        
        if (root.left != null) solveIt2(root.left);
        if (root.right != null) solveIt2(root.right);
    }
}