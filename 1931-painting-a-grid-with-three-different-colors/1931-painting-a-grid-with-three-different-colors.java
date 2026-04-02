class Solution {
    public int colorTheGrid(int m, int n) {
        List<List<Integer>> patterns = new ArrayList<>();
        dfs(m, new int[m], 0, patterns); // populate patterns array

        int p = 3 * (int)Math.pow(2, (m - 1));

        int[][] dp = new int[n][p];    
        for (int j = 0; j < p; j++) {
            dp[0][j] = 1;
        }   
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < p; k++) {
                    if (compatible(patterns.get(j), patterns.get(k))) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % (1_000_000_007);
                    }
                }
            }
        }

        int ans = 0;
        for (int j = 0; j < p; j++) {
            ans = (ans + dp[n - 1][j]) % (1_000_000_007);
        }
        return ans;
    }

    static void dfs(int m, int[] current, int depth, List<List<Integer>> patterns) {
        if (depth == m) {
            List<Integer> pattern = new ArrayList<>();
            for (int c : current) pattern.add(c);
            patterns.add(pattern);
            return;
        }

        for (int color = 0; color < 3; color++) {
            if (depth == 0 || color != current[depth - 1]) {
                current[depth] = color;
                dfs(m, current, depth + 1, patterns);
            }
        }
    }

    private boolean compatible(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == b.get(i)) return false;
        }
        return true;
    }
}