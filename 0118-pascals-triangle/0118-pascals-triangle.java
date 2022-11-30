class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
    
        
        int[][] grid = new int[numRows][numRows];

        for (int i = 0; i < numRows; i++) {
            grid[i][0] = 1;
        }

        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numRows; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i - 1][j - 1];
            }
        }
        
        for (int i = 0; i < numRows; i++) {
            sol.add(new ArrayList<Integer>());
            for (int j = 0; j < numRows; j++) {
                if (grid[i][j] != 0) sol.get(i).add(grid[i][j]);
            }
        }

        print(grid, numRows);

        return sol;
    }

    void print(int[][] grid, int numRows) {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        
    }
}