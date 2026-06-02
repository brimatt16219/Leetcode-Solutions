class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length - 1;
        int total = 0;
        for (int i = n; i >= 0; i -= 3) {
            if (i <= 0) {
                total += cost[i];
                break;
            }
            else if (i <= 1) {
                total += cost[i] + cost[i - 1];
                break;
            }
            total += cost[i] + cost[i - 1];
        }
        return total;
    }
}