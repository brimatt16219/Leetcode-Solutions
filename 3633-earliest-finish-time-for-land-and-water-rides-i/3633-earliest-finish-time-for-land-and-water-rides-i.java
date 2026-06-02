class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int totalMin = Integer.MAX_VALUE;

        // Try land first, then water
        for (int i = 0; i < n; i++) {  
            int landFinish = landStartTime[i] + landDuration[i];
            for (int j = 0; j < m; j++) {  
                int waterStart = Math.max(landFinish, waterStartTime[j]); // wait if needed
                int finish = waterStart + waterDuration[j];
                totalMin = Math.min(totalMin, finish);
            }
        }

        // Try water first, then land
        for (int j = 0; j < m; j++) { 
            int waterFinish = waterStartTime[j] + waterDuration[j];
            for (int i = 0; i < n; i++) { 
                int landStart = Math.max(waterFinish, landStartTime[i]); //  wait if needed
                int finish = landStart + landDuration[i];
                totalMin = Math.min(totalMin, finish);
            }
        }

        return totalMin;
    }
}