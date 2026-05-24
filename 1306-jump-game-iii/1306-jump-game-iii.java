class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];

        return dfs(arr, visited, start);
    }

    public boolean dfs (int[] arr, boolean[] visited, int i) {
        if (arr[i] == 0) {
            return true;
        }
        if (visited[i]) {
            return false;
        }

        int left = i - arr[i];
        int right = i + arr[i];
        int[] directions = new int[]{left, right};

        visited[i] = true;
        for (int dir : directions) {
            if (dir >= 0 && dir < arr.length) {
                if (dfs(arr, visited, dir)) {
                    return true;
                }
            }
        }
        visited[i] = false;
        return false;
    }
}