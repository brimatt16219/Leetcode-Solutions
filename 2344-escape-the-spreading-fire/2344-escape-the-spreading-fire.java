import java.util.*;

class Solution {
    private static final int INF = 1_000_000_000; // large enough "infinite" time
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maximumMinutes(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] fireTime = computeFireTimes(grid, m, n);

        // If you can still make it no matter how long you wait, return 1e9.
        if (canReachWithWait(grid, fireTime, m, n, 1_000_000_000)) {
            return 1_000_000_000;
        }

        // Otherwise binary search the maximum feasible wait.
        int lo = 0, hi = 1_000_000_000, ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canReachWithWait(grid, fireTime, m, n, mid)) {
                ans = mid;
                lo = mid + 1; // try to wait more
            } else {
                hi = mid - 1; // wait less
            }
        }
        return ans;
    }

    // Multi-source BFS from all initial fire cells to compute earliest arrival time of fire
    private int[][] computeFireTimes(int[][] grid, int m, int n) {
        int[][] F = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(F[i], INF);

        Deque<int[]> dq = new ArrayDeque<>();
        // Initialize with all fire sources at time 0
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    F[r][c] = 0;
                    dq.offer(new int[]{r, c});
                }
            }
        }

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int r = cur[0], c = cur[1];
            int t = F[r][c];
            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (grid[nr][nc] == 2) continue; // wall blocks fire
                if (F[nr][nc] > t + 1) {
                    F[nr][nc] = t + 1;
                    dq.offer(new int[]{nr, nc});
                }
            }
        }
        return F;
    }

    // Check if it's possible to reach goal when you wait 'wait' minutes before your first step
    private boolean canReachWithWait(int[][] grid, int[][] F, int m, int n, int wait) {
        // Start cell must not be on fire before you leave it:
        // valid if F[0][0] == INF or wait < F[0][0]
        if (grid[0][0] == 2) return false; // sanity (by constraints it's 0)
        if (F[0][0] != INF && wait >= F[0][0]) return false;

        boolean[][] vis = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();
        // state: (r, c, time)
        q.offer(new int[]{0, 0, wait});
        vis[0][0] = true;

        int gr = m - 1, gc = n - 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], t = cur[2];
            // If already at goal, success
            if (r == gr && c == gc) return true;

            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (grid[nr][nc] == 2) continue; // wall
                if (vis[nr][nc]) continue;

                int arrive = t + 1;

                // fire constraint
                if (nr == gr && nc == gc) {
                    // goal allows equality: arrive <= F[goal] or F[goal] == INF
                    if (F[nr][nc] != INF && arrive > F[nr][nc]) continue;
                } else {
                    // intermediate cell requires strict: arrive < F[nr][nc] or F==INF
                    if (F[nr][nc] != INF && arrive >= F[nr][nc]) continue;
                }

                vis[nr][nc] = true;
                q.offer(new int[]{nr, nc, arrive});
            }
        }
        return false;
    }
}
