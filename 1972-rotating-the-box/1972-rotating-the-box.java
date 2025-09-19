class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int ROWS = boxGrid.length;
        int COLS = boxGrid[0].length;

        for (int r = 0; r < ROWS; r++) {
            int i = COLS - 1; // position at end, where stone should fall
            for (int c = COLS - 1; c >= 0; c--) {
                if (boxGrid[r][c] == '#') {
                    char temp = boxGrid[r][c];
                    boxGrid[r][c] = boxGrid[r][i];
                    boxGrid[r][i] = temp;
                    i --;
                }
                else if (boxGrid[r][c] == '*') {
                    i = c - 1;
                }
            }
        }

        char[][] res = new char[COLS][ROWS];
        for (int c = 0; c < COLS; c++) {
            for (int r = ROWS - 1; r >= 0; r--) {
                res[c][ROWS - 1 - r] = boxGrid[r][c];
            }
        }

        return res;
    }
}