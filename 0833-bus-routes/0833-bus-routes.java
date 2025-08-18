class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        int n = routes.length;

        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int bus = 0; bus < n; bus++) {
            for (int stop : routes[bus]) {
                stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(bus);
            }
        }

        // BFS over stops each layer is one more bus
        Queue<Integer> q = new ArrayDeque<>();
        q.add(source);

        Set<Integer> visitedStops = new HashSet<>();
        visitedStops.add(source);
        
        boolean[] visitedBus = new boolean[n];

        int busesTaken = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            busesTaken ++;

            for (int i = 0; i < size; i++) {
                int stop = q.poll();

                List<Integer> busesHere = stopToBuses.get(stop);
                if (busesHere == null) continue;

                for (int bus : busesHere) {
                    if (visitedBus[bus]) continue;
                    visitedBus[bus] = true;

                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) return busesTaken;

                        if (visitedStops.add(nextStop)) {
                            q.add(nextStop);
                        }
                    }
                }
            }
        }
        return -1;
    }
}