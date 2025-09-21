class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] colors = new int[n];
        int[] ans = new int[queries.length];
        int equalAdj = 0;

        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int newColor = queries[i][1];
            int oldColor = colors[idx];

            if (oldColor == newColor) {
                ans[i] = equalAdj;
                continue;
            }

            if (oldColor != 0) {
                if (idx > 0 && colors[idx - 1] == oldColor) equalAdj--;
                if (idx + 1 < n && colors[idx + 1] == oldColor) equalAdj--;
            }

            colors[idx] = newColor;

            if (newColor != 0) {
                if (idx > 0 && colors[idx - 1] == newColor) equalAdj++;
                if (idx + 1 < n && colors[idx + 1] == newColor) equalAdj++;
            }

            ans[i] = equalAdj;
        }

        return ans;
    }
}