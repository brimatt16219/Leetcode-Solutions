class Solution {
    public int rob(int[] nums) {
        
        if (nums.length == 1) return nums[0];
        int length = nums.length;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
        
        //return Math.max(solveIt(0, nums), solveIt(1, nums));
    }
    
    int solveIt(int index, int[] nums)
    {
        if (index < nums.length)
            return nums[index] + Math.max(solveIt(index + 2, nums), solveIt(index + 3, nums));
        return 0;
    }
}