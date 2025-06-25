class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            int num = e.getKey();
            int freq = e.getValue();
            buckets[freq].add(num);
        }
        
        int[] res = new int[k];
        int idx = 0;
        for (int freq = buckets.length - 1; freq >= 1 && idx < k; freq--) {
            for (int num : buckets[freq]) {
                res[idx++] = num;
                if (idx == k) return res;
            }
        }
        return res;
    }
}