class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, res);
        return res;
    }

    static void dfs(int[] nums, int k, List<Integer> subset, List<List<Integer>> res) {
        if (k >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[k]);
        dfs(nums, k + 1, subset, res);
        subset.remove(subset.size() - 1);
        dfs(nums, k + 1, subset, res);
    } 
}