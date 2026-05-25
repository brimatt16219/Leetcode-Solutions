class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int res = nums[0];
        while (l <= r) {

            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }

            int m = l + (r - l) / 2;
            res = Math.min(res, nums[m]);
            if ((nums[m] > nums[l]) || (nums[m] == nums[l] && nums[m] != nums[r])) {
                l = m + 1;
            }
            else if ((nums[m] < nums[r]) || (nums[m] == nums[r] && nums[m] != nums[l])){ // 6 7 1 2 3 4 5
                r = m - 1;
            }
            else { // nums[l] == nums[m] == nums[r]
                r--;
                l++;
            }
        }
        return res;
    }
}