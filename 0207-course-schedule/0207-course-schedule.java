class Solution {

    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int crs) {
        if (visited.contains(crs)) {
            return false;
        }
        if (preMap.get(crs).isEmpty()) {
            return true;
        }

        visited.add(crs);
        for (int pre : preMap.get(crs)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visited.remove(crs);
        preMap.put(crs, new ArrayList<>());
        return true;
    }
}