class Solution {
    public int longestBalanced(int[] nums) {
        Set<Integer> even = new HashSet<>();
        Set<Integer> odd = new HashSet<>();

        int max = 0;

        for (int l = 0; l < nums.length; l++) {
            even.clear();
            odd.clear();
            for (int r = l; r < nums.length; r++) {
                if (nums[r] % 2 == 0) {
                    even.add(nums[r]);  // add the VALUE, not the index
                } else {
                    odd.add(nums[r]);
                }
                if (even.size() == odd.size()) {
                    max = Math.max(max, r - l + 1);
                }
            }
        }

        return max;
    }
}