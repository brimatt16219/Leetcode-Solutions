class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = 0;
        int last = matrix[0].length - 1;

        for (int i = 0; i < matrix.length; i++) {
            if (target <= matrix[i][last]) {
                row = i;
                break;
            }
        }

        int l = 0;
        int r = last;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (matrix[row][mid] == target) return true;

            else if (matrix[row][mid] > target) r = mid - 1;

            else l = mid + 1;
        }
        return false;
    }
}