class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        // Only edges between two online nodes are usable at all
        // (online[0] and online[n-1] are guaranteed true)
        List<int[]> validEdges = new ArrayList<>();
        for (int[] e : edges) {
            if (online[e[0]] && online[e[1]]) {
                validEdges.add(e);
            }
        }
        if (validEdges.isEmpty()) return -1;

        int[] costs = validEdges.stream()
                                 .mapToInt(e -> e[2])
                                 .distinct()
                                 .sorted()
                                 .toArray();

        int lo = 0, hi = costs.length - 1, ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long minCost = shortestPathWithThreshold(validEdges, n, costs[mid]);

            if (minCost != -1 && minCost <= k) {
                ans = costs[mid];   // feasible — try a stricter (higher) threshold
                lo = mid + 1;
            } else {
                hi = mid - 1;       // not feasible — relax threshold
            }
        }

        return ans;
    }

    // Dijkstra using only edges with cost >= threshold
    private long shortestPathWithThreshold(List<int[]> edges, int n, int threshold) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] e : edges) {
            if (e[2] >= threshold) {
                adj.computeIfAbsent(e[0], x -> new ArrayList<>())
                   .add(new int[]{e[1], e[2]});
            }
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            int u = (int) top[0];
            long d = top[1];

            if (d > dist[u]) continue;
            if (u == n - 1) return d;

            List<int[]> neighbors = adj.get(u);
            if (neighbors == null) continue;

            for (int[] nei : neighbors) {
                int v = nei[0];
                long nd = d + nei[1];
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new long[]{v, nd});
                }
            }
        }

        return dist[n - 1] == Long.MAX_VALUE ? -1 : dist[n - 1];
    }
}