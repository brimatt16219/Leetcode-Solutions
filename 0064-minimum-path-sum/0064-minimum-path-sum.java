class Solution {
    public int minPathSum(int[][] grid) {
        int[][] sub = new int[grid.length][grid[0].length];

        int prev = 0;
        for (int i = 0; i < sub.length; i++) {
            
            sub[i][0] = grid[i][0] + prev;
            prev = sub[i][0];
        }
        prev = 0;
        for (int i = 0; i < sub[0].length; i++) {
            
            sub[0][i] = grid[0][i] + prev;
            prev = sub[0][i];
        }
        //print(sub);

        for (int i = 1; i < sub.length; i++) {
            for (int j = 1; j < sub[0].length; j++) {
                sub[i][j] = min(sub[i - 1][j], sub[i][j - 1]) + grid[i][j];
            }
        }

        print(sub);
        return sub[sub.length - 1][sub[0].length - 1];
    }

    void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    int min(int a, int b) {
        if (a < b) return a;
        return b;
    }
}