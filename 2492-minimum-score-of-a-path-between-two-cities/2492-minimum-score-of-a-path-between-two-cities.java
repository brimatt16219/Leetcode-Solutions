class Solution {
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] road : roads) {
            int a = road[0], b = road[1], dist = road[2];
            adj.computeIfAbsent(a, x -> new ArrayList<>()).add(new int[]{b, dist});
            adj.computeIfAbsent(b, x -> new ArrayList<>()).add(new int[]{a, dist});
        }

        boolean[] visited = new boolean[n + 1];
        int minScore = Integer.MAX_VALUE;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            List<int[]> neighbors = adj.getOrDefault(cur, new ArrayList<>());
            for (int[] nei : neighbors) {
                int next = nei[0];
                int dist = nei[1];

                minScore = Math.min(minScore, dist);

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return minScore;
    }
}