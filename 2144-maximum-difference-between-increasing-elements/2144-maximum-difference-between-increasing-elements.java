class Solution {
    public int maximumDifference(int[] nums) {
        int max = -1;
        int min = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < min) min = nums[i];

            if (nums[i + 1] - min == 0) continue;

            if (nums[i + 1] - min > max) {
                max = nums[i + 1] - min;
                //System.out.println("Updated max at " + i);
            }
        }
        return max;
    }
}