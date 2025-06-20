class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            // print(dp);
            for (int coin : coins) {
                if (i >= coin) dp[i] = min(dp[i], dp[i - coin] + 1);
            }
            
        }
        // print(dp);

        return dp[amount] > amount ? -1 : dp[amount];
    }

    private int min(int a, int b) {
        return (a < b) ? a : b;
    }

    void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" \t" + arr[i]);
        }
        System.out.println();
    }
}