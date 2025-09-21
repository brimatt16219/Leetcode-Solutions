class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0]; 
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(new int[] { intervals[0][0], intervals[0][1] });

        for (int i = 1; i < intervals.length; i++) {
            int[] last = merged.get(merged.size() - 1);
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start <= last[1]) {
                last[1] = Math.max(last[1], end);
            }
            else {
                merged.add(new int[] {start, end});
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}