class Solution {


    public int uniquePaths(int m, int n) {
        
        int[][] sub = new int[m][n];

        for (int i = 0; i < sub.length; i++) {
            sub[i][0] = 1;
        }
        for (int i = 0; i < sub[0].length; i++) {
            sub[0][i] = 1;
        }

        for (int i = 1; i < sub.length; i++) {
            for (int j = 1; j < sub[i].length; j++) {
                sub[i][j] = sub[i - 1][j] + sub[i][j - 1];
            }
        }

        //print(sub);

        return sub[m - 1][n - 1];
    }

    void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }


    int max(int a, int b) {
        return (a > b) ? a : b;
    }
}