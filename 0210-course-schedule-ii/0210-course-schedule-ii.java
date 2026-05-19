class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereq = new HashMap<>();
        for (int[] p : prerequisites) {
            prereq.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, prereq, visited, cycle, output)) {
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = output.get(i);
        }
        return res;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> prereq, Set<Integer> visited, Set<Integer> cycle, List<Integer> output) {
        if (cycle.contains(course)) {
            return false;
        }
        if (visited.contains(course)) {
            return true;
        }

        cycle.add(course);
        for (int pre : prereq.getOrDefault(course, Collections.emptyList())) {
            if (!dfs(pre, prereq, visited, cycle, output)) {
                return false;
            }
        }
        cycle.remove(course);
        visited.add(course);
        output.add(course);
        return true;
    }
}