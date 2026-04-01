class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(candidates, 0, res, subset, target);
        return res;
    }

    static void dfs(int[] candidates, int k, List<List<Integer>> res, List<Integer> subset, int target) {
        int sum = subset.stream().mapToInt(Integer::intValue).sum();
        if (sum == target) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if (k >= candidates.length || sum > target) {
            return;
        }

        subset.add(candidates[k]);
        dfs(candidates, k, res, subset, target);
        subset.remove(subset.size() - 1);
        dfs(candidates, k + 1, res, subset, target);
    }
}