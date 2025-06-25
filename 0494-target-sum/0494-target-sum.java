class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();

        dp.put(0, 1);

        for (int num : nums) {
            Map<Integer, Integer> next = new HashMap<>();

            for (Map.Entry<Integer, Integer> e : dp.entrySet()) {
                int sum = e.getKey();
                int count = e.getValue();

                next.merge(sum + num, count, Integer::sum);
                next.merge(sum - num, count, Integer::sum);
            } 
            dp = next;
        }
        return dp.getOrDefault(target, 0);
    }
}