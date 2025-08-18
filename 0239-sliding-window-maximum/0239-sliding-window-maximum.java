class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int r = 0; r < n; r++) {
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[r]) {
                dq.pollLast();
            }
            dq.addLast(r);

            if (dq.peekFirst() <= r - k) {
                dq.pollFirst();
            }

            if (r + 1 >= k) {
                ans[r - k + 1] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}