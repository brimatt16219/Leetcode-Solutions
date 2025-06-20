class Solution {
    public int maxDistance(String s, int k) {
        int x = 0, y = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'N')      ++y;
            else if (c == 'S') --y;
            else if (c == 'E') ++x;
            else if (c == 'W') --x;
            int raw = Math.abs(x) + Math.abs(y);
            // each flip can add up to 2, but you can't exceed i+1 total steps
            int bestAtI = Math.min(raw + 2 * k, i + 1);
            ans = Math.max(ans, bestAtI);
        }
        return ans;
    }
}
