class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int mid = n / 2;

        int[] yCnt = new int[3];
        int[] oCnt = new int[3];
        int ySize = 0, oSize = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                boolean onY = 
                    // top-left to center diagonal
                    ((r == c) && r <= mid)
                    // top right to center diagonal
                    || ((r + c == n - 1) && r <= mid)
                    // vertical down
                    || (c == mid && r >= mid);
                
                int val = grid[r][c];

                if (onY) {
                    yCnt[val]++;
                    ySize++;
                }
                else {
                    oCnt[val]++;
                    oSize++;
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                if (a == b) continue;
                int changesOnY = ySize - yCnt[a];
                int changesOffY = oSize - oCnt[b];
                ans = Math.min(ans, changesOnY + changesOffY);
            }
        }
        return ans;
    }
}