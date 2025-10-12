class Solution {
    public int[] minEdgeReversals(int n, int[][] edges) {
        // Build weighted adjacency
        // for u->v: (u->v, w = 0), (v->u, w=1)
        List<int[]>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(new int[]{v, 0});
            g[v].add(new int[]{u, 1});
        }

        int[] parent = new int[n];
        int[] wFromParent = new int[n]; // Weight of edge parent->node
        Arrays.fill(parent, -1);

        // First pass: build the rooted tree at 0 and compute ans0
        int ans0 = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        parent[0] = -2;

        while(!stack.isEmpty()) {
            int u = stack.pop();
            for (int[] e : g[u]) {
                int v = e[0], w = e[1];
                if (v == parent[u]) continue;
                if (parent[v] == -1) {
                    parent[v] = u;
                    wFromParent[v] = w;
                    ans0 += w;
                    stack.push(v);
                }
            }
        }

        int[] ans = new int[n];
        ans[0] = ans0;

        Deque<Integer> stack2 = new ArrayDeque<>();
        stack2.push(0);
        while (!stack2.isEmpty()) {
            int u = stack2.pop();
            for (int[] e : g[u]) {
                int v = e[0], w = e[1];
                if (v == parent[u]) continue;

                ans[v] = ans[u] + (w == 0 ? 1 : -1);
                stack2.push(v);
            }
        }

        return ans;
    }
}