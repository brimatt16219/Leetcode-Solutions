class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < intervals.length - 1; i++) {
            int[] i1 = intervals[i];
            int[] i2 = intervals[i + 1];

            if (i1[1] > i2[0]) {
                return false;
            }
        }
        return true;
    }
}