class Solution {

    boolean[] used;
    List<List<Integer>> list;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        list = new ArrayList<>();
        backtrack(list, new ArrayList(), nums);

        return list;
    }

    void backtrack(List<List<Integer>> list, List<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);

            backtrack(list, path, nums);

            path.remove(path.size() - 1);
            used[i] = false;
        }

        return;
    }
}