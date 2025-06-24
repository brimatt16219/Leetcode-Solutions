class Solution {

    public int orangesRotting(int[][] grid) {

        int m;
        int n;
        
        m = grid.length;
        n = grid[0].length;

        Deque<int[]> queue = new ArrayDeque<>();

        int freshCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) freshCount ++;
                else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }
        if (freshCount == 0) return 0;

        int time = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int t = cur[2];

            time = Math.max(t, time);
            for (int[] d : dirs) {
                int dr = r + d[0];
                int dc = c + d[1];

                if (dr < 0 || dc < 0 || dr >= m || dc >= n) continue;
                if (grid[dr][dc] != 1) continue;

                grid[dr][dc] = 2;
                freshCount --;
                queue.offer(new int[]{dr, dc, t + 1});
            }
        }
        return freshCount == 0 ? time : -1;
    }


}