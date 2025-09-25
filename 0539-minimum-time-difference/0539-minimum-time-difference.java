class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] time = new int[timePoints.size()];

        for (int i = 0; i < time.length; i++) {
            String[] split = timePoints.get(i).split(":");
            time[i] = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }
        Arrays.sort(time);
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < time.length - 1; i++) {
            ans = Math.min(ans, time[i + 1] - time[i]);
        }
        return Math.min(ans, 24 * 60 - time[time.length - 1] + time[0]);
    }
}