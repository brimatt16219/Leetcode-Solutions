class Solution {


    List path;
    List ans;

    public List<List<Integer>> subsets(int[] nums) {

        path = new ArrayList<>();
        ans = new ArrayList<>();
        backtrack(nums, 0);

        return ans;
    }

    void backtrack(int[] nums, int k) {

        ans.add(new ArrayList<>(path));

        for (int i = k; i < nums.length; i++) {
            path.add(nums[i]);

            backtrack(nums, i + 1);

            path.remove(path.size() - 1);
        } 
    }
}