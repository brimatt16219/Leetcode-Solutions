class Solution {

    int[] dy = {0 , -1, 1, 0};
    int[] dx = {1, 0, 0, -1};

    int[][] visited;

    public int numIslands(char[][] grid) {
        
        visited = new int[grid.length][grid[0].length];

        int islands = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    islands++;
                    dfs(i, j, grid);
                }
            }
        }
        return islands;
    }

    void dfs(int r, int c, char[][] grid) {
        if (r < 0 || c < 0 || r >= visited.length || c >= visited[0].length || visited[r][c] == 1) return;
        visited[r][c] = 1;

        if (grid[r][c] == '0') return;

        for (int i = 0; i < 4; i++) {
            int dr = dy[i] + r;
            int dc = dx[i] + c;
            dfs(dr, dc, grid);
        }
    }
}