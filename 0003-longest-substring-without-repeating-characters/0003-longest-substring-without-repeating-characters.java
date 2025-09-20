class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> last = new HashMap<>();

        int best = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (last.containsKey(ch) && last.get(ch) >= left) {
                left = last.get(ch) + 1;
            }

            last.put(ch, right);
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}