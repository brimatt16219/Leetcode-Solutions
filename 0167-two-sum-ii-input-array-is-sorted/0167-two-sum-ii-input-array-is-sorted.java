class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        int curSum = 0;
        while (l < r) {
            curSum = numbers[l] + numbers[r];
            if (curSum > target) {
                r--;
            }
            else if (curSum < target) {
                l++;
            }
            else {
                return new int[]{l + 1, r + 1};
            }
        }
        return new int[2];
    }
}