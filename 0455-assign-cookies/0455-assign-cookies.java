class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        

        int happy = 0;
        int iter = 0;

        if (s.length == 0) return happy;
        for (int i = 0; i < g.length; i++) {
            if (iter == s.length) break;
            if (g[i] <= s[iter]) {
                happy ++;
                iter++;
            }
            else {
                i--;
                iter ++;
            }
        }
        return happy;
    }
}