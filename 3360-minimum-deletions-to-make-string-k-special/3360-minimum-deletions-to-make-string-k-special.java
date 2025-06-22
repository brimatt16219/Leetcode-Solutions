import java.util.*;

class Solution {
    public int minimumDeletions(String word, int k) {
        // 1) Count frequencies of each lowercase letter
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // 2) Extract only the positive frequencies into a list & sort it
        List<Integer> pos = new ArrayList<>();
        for (int f : freq) {
            if (f > 0) pos.add(f);
        }
        Collections.sort(pos);
        
        // 3) Try every possible "minimum frequency" m = pos.get(i)
        //    and compute how many deletions it costs to force every letter
        //    into the interval [m, m + k].
        int best = Integer.MAX_VALUE;
        int d = pos.size();
        for (int i = 0; i < d; i++) {
            int m = pos.get(i);
            int cost = 0;
            int upper = m + k;
            for (int f : pos) {
                if (f < m) {
                    // must delete all occurrences of this letter
                    cost += f;
                } else if (f > upper) {
                    // must trim it down to upper
                    cost += f - upper;
                }
                // otherwise m <= f <= upper, no deletions needed
            }
            best = Math.min(best, cost);
        }
        
        // If there were no letters at all, best stays INF → but word is non-empty by prompt
        return best;
    }
}
