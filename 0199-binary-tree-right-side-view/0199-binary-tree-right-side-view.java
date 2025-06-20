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
    static boolean[] visited;
    static List<Integer> right = new ArrayList<Integer>();

    public List<Integer> rightSideView(TreeNode root) {
        right.clear();
        int depth = 0;
        depth = getDepth(root);
        // System.out.println(depth);

        visited = new boolean[depth];
        solution(root, 0);

        return right;
    }

    void solution(TreeNode root, int level) {
        if (root == null) return;
        if (visited[level] == false) {
            // System.out.println("Adding " + root.val + " since we havent visited level " + level);
            visited[level] = true;
            right.add(root.val);
        }

        solution(root.right, level + 1);
        solution(root.left, level + 1);
    }

    int getDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}