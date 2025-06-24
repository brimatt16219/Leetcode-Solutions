class Solution {

    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};

    int[][] visited;

    int m;
    int n;

    int max;

    public int maxAreaOfIsland(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        max = 0;

        visited = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    // System.out.println("found island ");
                    int size = dfs(i, j, grid);
                    // System.out.println("size is " + size);
                    max = Math.max(size, max);
                }
            }
        }

        return max;
    }

    int dfs(int r, int c, int[][] grid) {

        if (r < 0 || c < 0 || r >= m || c >= n) return 0;

        if (visited[r][c] == 1) return 0;

        if (grid[r][c] == 0) return 0;
        
        visited[r][c] = 1;
        int area = 1;

        for (int i = 0; i < 4; i++) {
            int dr = dy[i] + r;
            int dc = dx[i] + c;

            area += dfs(dr, dc, grid);
        }

        return area;
    }
}