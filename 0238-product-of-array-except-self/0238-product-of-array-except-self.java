class Solution {
    public int[] productExceptSelf(int[] nums) {
        //   optimized solution..||TC:O(N), SC:O(N)
        int n = nums.length;
        int ans[] = new int[n];
        ans[0] = 1;
        int left = 1;
        //we find the left pre. product of each element ans stores in ans named array 
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        //here we find the product of each element except itself and updating the right suffix prod.
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = right * ans[i];
            right *= nums[i];
        }
        return ans;
    }
}