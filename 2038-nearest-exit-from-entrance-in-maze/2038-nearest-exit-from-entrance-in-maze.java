import java.util.*;

class Solution {
    // Directions: down, up, right, left
    private static final int[] DR = { 1, -1, 0,  0 };
    private static final int[] DC = { 0,  0, 1, -1 };

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        
        // Start from entrance, 0 steps
        int er = entrance[0], ec = entrance[1];
        visited[er][ec] = true;
        q.offer(new int[]{er, ec, 0});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], steps = cur[2];
            
            // If it's on the border and not the entrance → exit found
            if (!(r == er && c == ec)  // skip the entrance itself
               && (r == 0 || r == m - 1 || c == 0 || c == n - 1)) {
                return steps;
            }
            
            // Explore neighbors
            for (int d = 0; d < 4; d++) {
                int nr = r + DR[d], nc = c + DC[d];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;
                if (maze[nr][nc] == '+') continue;  // wall
                
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc, steps + 1});
            }
        }
        
        // No exit reachable
        return -1;
    }
}
