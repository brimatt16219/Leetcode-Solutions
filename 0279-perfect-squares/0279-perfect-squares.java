class Solution {

    public static int[] dn = {0, 1};

    public int numSquares(int n) {
        int least = greatestLesserSquare(n);
        System.out.println("least is: " + least);
        
        int[][] sub = new int[least + 1][n + 1];

        for (int i = 0; i < sub.length; i++) {
            sub[i][0] = n;
        }
        for (int i = 0; i < sub[0].length; i++) {
            sub[0][i] = n;
        }
        int square = 0;
        int diff = 0;
        for (int i = 1; i < sub.length; i++) {
            square = i * i;
            //System.out.println("square is now: " + square);
            for (int j = 1; j < sub[0].length; j++) {
                diff = j - ((j / square) * square);
                //System.out.println("j is: " + j + " square is: " + square + " diff is: " + diff);
                if (j == square) sub[i][j] = 1;
                else if (j % square == 0) sub[i][j] = j / square;
                else if (j > square){
                    sub[i][j] = min(1 + sub[i][j - square], sub[i - 1][j]);
                    //sub[i][j] = (j / square) + sub[i - 1][diff];
                }
                else {
                    sub[i][j] = sub[i - 1][j];
                }
                
            }
        }

        //print(sub);
        
        return sub[sub.length - 1][sub[0].length - 1];
    }

    void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print("\t" + grid[i][j]);
            }
            System.out.println();
        }
    }

    int min(int a, int b) {
        if (a < b) {
            return a;
        }
        return b;
    }
    

    int greatestLesserSquare(int n) {
        for (int i = 0; i < n; i++) {
            if (i * i > n) return i - 1;
        }
        return 0;
    }
}