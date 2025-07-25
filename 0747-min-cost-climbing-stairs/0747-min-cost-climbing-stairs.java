class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int[] dp = new int[cost.length + 1];
        dp[cost.length] = 0;
        dp[cost.length - 1] = cost[cost.length - 1];
        
        for (int i = cost.length - 2; i >= 0; i--) {
            dp[i] = cost[i] + min(dp[i + 1], dp[i + 2]);
            System.out.println("dp " + i + " " + dp[i]);
        }

        return min(dp[0], dp[1]);
    }

    int min(int a, int b) {
        return (a < b) ? a : b;
    }
}