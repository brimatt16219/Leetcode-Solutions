class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        backtrack(candidates, target, 0, new ArrayList<>(), used, ans);
        return ans;
    }

    private void backtrack(int[] candidates,
                        int remain,
                        int start,
                        List<Integer> path,
                        boolean[] used,
                        List<List<Integer>> ans) {
        if (remain == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (remain < 0) {
            return;   // overshot
        }

        for (int i = start; i < candidates.length; i++) {
            // 1) skip duplicates
            if (i > 0
            && candidates[i] == candidates[i-1]
            && !used[i-1]) {
                continue;
            }
            // 2) pick candidates[i]
            path.add(candidates[i]);
            used[i] = true;
            // 3) recurse with i+1 (can't reuse the same element)
            backtrack(candidates, remain - candidates[i], i + 1, path, used, ans);
            // 4) backtrack
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

}