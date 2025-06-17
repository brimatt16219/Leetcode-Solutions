class Solution {
    public int specialArray(int[] nums) {
        int special = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            special = i + 1;
            for (int j = 0; j < nums.length; j++) {
                System.out.println("nums[" + j + "] is " + nums[j]);
                if (special <= nums[j]) count ++;
            }
            System.out.println("count is " + count + " and special is " + special);
            if (count == special) return special;
        }
        return -1;
    }
}