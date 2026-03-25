class Solution {
    public int characterReplacement(String s, int k) {

        // Setup result and hash set and add all characters in s into the set
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        // For  each character in the set, 
        for (char c : set) {
            int count = 0, l = 0;
            for (int r = 0; r < s.length(); r++) {

                if (s.charAt(r) == c) { // increase count
                    count++;
                }

                while ((r - l + 1) - count > k) {
                    if (s.charAt(l) == c) {
                        count --;
                    }
                    l++;
                }

                res = Math.max(res, r - l + 1);
            }
        }
        return res;
    }
}