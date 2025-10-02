class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n = nums.size();
        if (x == 0) return 0; // can pick same index

        TreeSet<Integer> seen = new TreeSet<>();
        int ans = Integer.MAX_VALUE;

        for (int i = x; i < n; i++) {
            seen.add(nums.get(i - x));

            int val = nums.get(i);

            // closest sides on each side of BST
            Integer ceil = seen.ceiling(val);
            if (ceil != null) ans = Math.min(ans, Math.abs(ceil - val));

            Integer floor = seen.floor(val);
            if (floor != null) ans = Math.min(ans, Math.abs(floor - val));

            if (ans == 0) return 0; // cannot do better
        }
        return ans;
    }
}