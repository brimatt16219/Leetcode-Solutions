class Solution {
    public long perfectPairs(int[] nums) {
        int n = nums.length;

        // Take absolute values and sort
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Math.abs((long) nums[i]);
        }
        Arrays.sort(arr);

        long count = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            // Make sure j is always ahead of i
            if (j <= i) j = i + 1;

            // Advance j while arr[j] fits in the window
            while (j < n && arr[j] <= 2 * arr[i]) {
                j++;
            }

            // All elements from i+1 to j-1 are valid partners
            count += (j - i - 1);
        }

        return count;
    }
}