class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = String.valueOf(nums[i])
                .chars()
                .map(Character::getNumericValue)
                .sum();
            nums[i] = sum;
            min = Math.min(sum, min);
        }
        return min;
    }
}