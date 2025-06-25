class Solution {
    public int characterReplacement(String s, int k) {

        int[] counts = new int[26];

        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int ans = 0;
        
        for (right = 0; right < s.length(); right ++ ) {
            char r = s.charAt(right);
            counts[r - 'A']++;
            maxFreq = Math.max(maxFreq, counts[r - 'A']);
            while ((right - left + 1) - maxFreq > k) {
                char l = s.charAt(left);
                counts[l - 'A'] --;
                left ++;
            }
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}