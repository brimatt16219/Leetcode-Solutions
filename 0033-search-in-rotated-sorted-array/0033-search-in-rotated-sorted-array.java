class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        // [4,5,6,7,8,0,1,2]
        // l = 4, m = 7, r = 2, target = 8
        


        // [5,6,0,1,2,3,4]
        // l = 5, m = 1, r = 4, target = 0
        // if target < m || target > r search left


        while (l <= r) {
            int m = l + ((r - l) / 2);

            if (nums[m] == target) return m;

            if (nums[m] >= nums[l]) { // we are in left sorted portion of array
                if (target > nums[m] || target < nums[l]) {// if target is above m or below l, do searhc on right
                    l = m + 1;
                }
                else {
                    r = m - 1;
                }
            }
            else { // right sorted portion
                if (target < nums[m] || target > nums[r]) {
                    r = m - 1;
                }
                else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}