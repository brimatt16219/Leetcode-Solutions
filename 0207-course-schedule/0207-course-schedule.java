class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] preMap = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            preMap[i] = new ArrayList<>();
        }
        for (int[] pair : prerequisites) {
            preMap[pair[0]].add(pair[1]);
        }

        boolean[] visiting = new boolean[numCourses];
        boolean[] checked = new boolean[numCourses];

        class DFS {
            boolean dfs(int c) {
                if (visiting[c]) {
                    return false;
                } 
                if (checked[c]) {
                    return true;
                }

                visiting[c] = true;
                for (int pre : preMap[c]) {
                    if (!dfs(pre)) {
                        return false;
                    }
                }

                visiting[c] = false;
                checked[c] = true;
                return true;
            }
        }

        DFS helper = new DFS();

        for (int course = 0; course < numCourses; course++) {
            if (!helper.dfs(course)) {
                return false;
            }
        }
        return true;
    }
}