class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] freq = new int[26];

        for (char t : tasks) {
            freq[t - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                maxHeap.offer(f);
            }
        }

        Deque<int[]> cool = new ArrayDeque<>();

        int time = 0;
        while (!maxHeap.isEmpty() || !cool.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int cnt = maxHeap.poll() - 1;

                if (cnt > 0) {
                    cool.offer(new int[] {cnt, time + n});
                }
            }

            if (!cool.isEmpty() && cool.peek()[1] == time) {
                maxHeap.offer(cool.poll()[0]);
            }
        }
        return time;
    }
}