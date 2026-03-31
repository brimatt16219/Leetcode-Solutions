class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        // Do a multi BFS on the thieves
        // Then do a maxHeap dijkstras to find safest path;
        int n = grid.size();
        int[][] min = bfs(grid, n); // BFS
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        boolean[][] visited = new boolean[n][n];

        maxHeap.offer(new int[] {min[0][0], 0, 0});
        visited[0][0] = true;

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int dist = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (r == n - 1 && c == n - 1) { // we reached end
                return dist;
            }

            for (int[] dir : new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
                int r2 = r + dir[0];
                int c2 = c + dir[1];
                if (isValid(r2, c2, n) && !visited[r2][c2]) {
                    visited[r2][c2] = true;
                    int dist2 = Math.min(dist, min[r2][c2]);
                    maxHeap.offer(new int[]{dist2, r2, c2});
                }
            }
        }
        return 0;
    }

    private int[][] bfs(List<List<Integer>> grid, int n) {
        int[][] min = new int[n][n];
        for (int[] row : min) Arrays.fill(row, -1);
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    q.offer(new int[]{r, c, 0});
                    min[r][c] = 0; // thieves will be 0, everything else -1
                }
            }
        }

        // do bfs now
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], dist = curr[2];

            for (int[] dir : new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
                int r2 = r + dir[0];
                int c2 = c + dir[1];
                if (isValid(r2, c2, n) && min[r2][c2] == -1) {
                    min[r2][c2] = dist + 1;
                    q.offer(new int[]{r2, c2, dist + 1});
                }
            }
        }
        return min;
    }

    private boolean isValid(int r, int c, int n) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }
}