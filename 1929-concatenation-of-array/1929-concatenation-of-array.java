class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length * 2;
        int[] res = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            res[i] = nums[j++];
            if (j >= nums.length) j = 0;
        }
        return res;
    }
}