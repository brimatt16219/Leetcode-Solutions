class Solution {

    int[] prefix;

    public Solution(int[] w) {
        prefix = new int[w.length + 1];
        for (int i = 0; i < w.length; i++) {
            prefix[i + 1] = prefix[i] + w[i];
        }
    }
    
    public int pickIndex() {
        double random = prefix[prefix.length - 1] * Math.random();
        int l = 1;
        int r = prefix.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (prefix[m] <= random) {
                l = m + 1;
            }
            else {
                r = m;
            }
        }
        return l - 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */