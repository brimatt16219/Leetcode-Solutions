class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>(positions.length);
        if (m <= 0 || n <= 0) return result;

        UnionFind uf = new UnionFind(m * n);
        boolean[] land = new boolean[m * n];
        int islands = 0;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] p : positions) {
            int r = p[0], c = p[1];
            int id = r * n + c;

            if (land[id]) { //duplicate
                result.add(islands);
                continue;
            }

            land[id] = true;
            uf.makeSet(id);
            islands++;

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                int nid = nr * n + nc;
                if (!land[nid]) continue; // neighbor is water

                if (uf.union(id, nid)) {
                    islands--;
                }
            }

            result.add(islands);
        }
        return result;
    }

    static class UnionFind {
        int[] parent;
        int[] size;
        boolean[] active;

        UnionFind(int total) {
            parent = new int[total];
            size = new int[total];
            active = new boolean[total];
        }

        void makeSet(int x) {
            if (!active[x]) {
                parent[x] = x;
                size[x] = 1;
                active[x] = true;
            }
        }

        int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        boolean union(int a, int b) {
            if (!active[a] || !active[b]) return false;
            int ra = find(a);
            int rb = find(b);
            if (ra == rb) return false;

            if (size[ra] < size[rb]) {
                int tmp = ra; ra = rb; rb = tmp;
            }
            parent[rb] = ra;
            size[ra] += size[rb];
            return true;
        }
    }
}