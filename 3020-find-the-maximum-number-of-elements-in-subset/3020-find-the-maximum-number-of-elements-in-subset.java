class Solution {
    public int maximumLength(int[] nums) {
        // freq map
        Map<Long, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.merge((long) num, 1, Integer::sum);
        }

        int best = 1;

        for (long x : freq.keySet()) {
            if (x == 1) {
                int ones = freq.get(1L);
                best = Math.max(best, ones % 2 == 0 ? ones - 1 : ones);
                continue;
            }

            int length = 0;
            long cur = x;

            while (freq.getOrDefault(cur, 0) >= 2) {
                length += 2;
                cur = cur * cur;
                if (cur > 2_000_000_000L) break;
            }

            if (freq.getOrDefault(cur, 0) >= 1) {
                length += 1;  // valid center
            } else if (length > 0) {
                length -= 1;  // ✅ drop one from the outermost pair, use it as center
            } else {
                length = 1;   // x itself appears 0 times somehow, skip
            }

            best = Math.max(best, length);
        }
        return best;
    }
}