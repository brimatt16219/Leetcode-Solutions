class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();

        int best = Integer.MIN_VALUE;

        int[][] dp = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int cur = grid.get(i).get(j);

                // best reachable from neighbors right or blow
                int maxReachable = Integer.MIN_VALUE;
                if (i + 1 < n) maxReachable = Math.max(maxReachable, dp[i + 1][j]);
                if (j + 1 < m) maxReachable = Math.max(maxReachable, dp[i][j + 1]);

                if (maxReachable != Integer.MIN_VALUE) {
                    best = Math.max(best, maxReachable - cur);
                }

                dp[i][j] = (maxReachable == Integer.MIN_VALUE ?
                    cur :
                    Math.max(maxReachable, cur));
            }
            // System.out.println("Best is: " + best);
            // print(dp, n, m);
        }
        // print(dp, n, m);
        return best;
    }

    static void print(int[][] grid, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}