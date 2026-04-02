class Solution {
    public int numOfWays(int n) {
        
        int P = 12; // There are 12 unique ways to make a row

        // 0, 1, 2 representing red, yellow, green
        List<int[]> patterns = new ArrayList<>();
        for (int a = 0; a < 3; a++)
            for (int b = 0; b < 3; b++)
                for (int c = 0; c < 3; c++)
                    if (a != b && b != c)
                        patterns.add(new int[]{a, b, c});

        int[][] dp = new int[n][P];

        for (int i = 0; i < P; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < P; j++) {
                for (int k = 0; k < P; k++) {
                    // Check if j and k are compatible 
                    if (compatible(patterns.get(j), patterns.get(k))) {
                        dp[i][j] = (dp[i][j]+  dp[i - 1][k]) % (1_000_000_007);
                    }
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < P; j++) {
            ans = (ans + dp[n - 1][j]) % (1_000_000_007);
        }
        return ans;
    }
    
    // Two arrays are compatible if they differ in every color
    private boolean compatible(int[] a, int[] b) {
        for (int i = 0; i < 3; i++) {
            if (a[i] == b[i]) return false;
        }
        return true;
    }
}