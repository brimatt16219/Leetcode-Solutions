class Solution {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);

        int curSum = 0, count = 0;

        for (int n : nums) {
            curSum += n;
            int diff = curSum - k;

            if (prefixSums.containsKey(diff)) {
                count += prefixSums.get(diff);
            }

            prefixSums.put(curSum, prefixSums.getOrDefault(curSum, 0) + 1);
        }

        return count;
    }
}