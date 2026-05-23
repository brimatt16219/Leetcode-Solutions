class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long max = 0;
        int n = bottomLeft.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int left = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int bottom = Math.max(bottomLeft[i][1], bottomLeft[j][1]);

                int right  = Math.min(topRight[i][0], topRight[j][0]);
                int top = Math.min(topRight[i][1], topRight[j][1]);

                int width = right - left;
                int length = top - bottom;

                if (width > 0 && length > 0) {
                    long side = Math.min(width, length);
                    max = Math.max(max, side * side);
                }
            }
        }
        return max;
    }
}