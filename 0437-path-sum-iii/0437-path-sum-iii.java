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

    long target;
    int answer;
    Map<Long, Integer> count;

    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        answer = 0;
        count = new HashMap<>();

        count.put(0L, 1);
        sol(root, 0L);
        
        return answer;
    }

    void sol(TreeNode root, long currentSum) {
        if (root == null) return;

        long curr = currentSum + root.val;

        answer += count.getOrDefault(curr - target, 0);

        count.put(curr, count.getOrDefault(curr, 0) + 1);

        sol(root.left, curr);
        sol(root.right, curr);

        count.put(curr, count.get(curr) - 1);
       
    }
}