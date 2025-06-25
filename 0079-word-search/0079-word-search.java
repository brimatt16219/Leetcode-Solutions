class Solution {

    int m, n;
    boolean[][] used;
    int[] dr = {1, -1, 0, 0}, dc ={0, 0, 1, -1};
    String word;
    char[][] board;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        this.word = word;
        used = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (dfs(r, c, 0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(int r, int c, int idx) {
        if (idx == word.length()) return true;

        if (r < 0 || c < 0 || r >= m || c >= n) return false;
        if (used[r][c]) return false;
        if (board[r][c] != word.charAt(idx)) return false;

        used[r][c] = true;

        for (int d = 0; d < 4; d++) {
            if (dfs(r +dr[d], c + dc[d], idx + 1)) {
                return true;
            }
        }

        used[r][c] = false;
        return false;
    }
}