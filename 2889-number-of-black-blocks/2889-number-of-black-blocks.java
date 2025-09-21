class Solution {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        Map<Long, Integer> map = new HashMap<>();

        for (int[] a : coordinates) {
            int x = a[0];
            int y = a[1];

            if (x == m - 1 && y == n - 1) {
                add(map, x - 1, y - 1);
            }
            else if (y == n - 1) {
                add(map, x, y - 1);
                add(map, x - 1, y - 1);
            }
            else if (x == m - 1) {
                add(map, x - 1, y);
                add(map, x - 1, y - 1);
            }
            else {
                add(map, x - 1, y);
                add(map, x, y - 1);
                add(map, x - 1, y - 1);
                add(map, x, y);
            }
        }

        long[] ans = new long[5];

        for (int count : map.values()) {
            ans[count]++;
        }

        long totalBlocks = (long) (m - 1) * (n - 1);
        long nonZeroBlocks = 0;
        for (int i = 0; i <= 4; i++) {
            nonZeroBlocks += ans[i];
        }
        ans[0] = totalBlocks - nonZeroBlocks;
        return ans;
    }

    private void add(Map<Long, Integer> map, int i, int j) {
        if (i < 0 || j < 0) return;
        long key = (((long) i) << 32) | (j & 0xffffffffL);
        map.put(key, map.getOrDefault(key, 0) + 1);
    }
}