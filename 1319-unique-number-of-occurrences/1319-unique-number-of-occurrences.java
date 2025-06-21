import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> freq = new HashMap<>();
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        Set<Integer> seenCounts = new HashSet<>();
        for (int count : freq.values()) {
            if (!seenCounts.add(count)) {
                return false;
            }
        }

        return true;
    }
}
