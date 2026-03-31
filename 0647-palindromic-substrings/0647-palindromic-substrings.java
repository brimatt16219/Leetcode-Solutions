class Solution {
    public int countSubstrings(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            res += countAround(s, i, i);
            res += countAround(s, i, i + 1);
        }
        return res;
    }

    private int countAround(String s, int l, int r) {
        int ans = 0;

        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
            ans++;
            l--;
            r++;
        }
        return ans;
    }
}