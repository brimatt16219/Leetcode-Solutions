class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        // System.out.println("before");
        // print(intervals);

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        // System.out.println("after");
        // print(intervals);

        int prev = 0;
        int count = 1;

        for (int i = 0; i < n; i++) {
            // System.out.println("comparing " + intervals[i][0] + " and " + intervals[prev][1]);
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                count++;
            }
        }
        return n - count; 
    }

    void print(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[0].length; j++) {
                System.out.print(intervals[i][j] + " ");
            }
            System.out.println();
        }
    }
}