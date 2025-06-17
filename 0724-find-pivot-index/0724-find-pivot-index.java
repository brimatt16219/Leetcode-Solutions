class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0; 

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        int left = 0;
        int right = total - nums[0];
        int index = 1;
        while (true) {
            System.out.println("Left: " + left + " right: " + right);
            if (left == right) return index - 1;
            if (index >= nums.length) {
                if (left == 0) return index - 1;
                return -1;
            }
            left += nums[index - 1];
            right -= nums[index];
            index++;
        }

    }
}