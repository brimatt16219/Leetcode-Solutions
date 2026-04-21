class Solution {

    private class UnionFind {

        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int p) {
            if (parent[p] != p) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) return;

            if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
            }
            else if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
            }
            else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);

        // 1tep 1: build connected components from allowed swaps
        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }

        // 2tep 2: group source values by their component root
        Map<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            components.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        // step 3: for each component, match source values to target values
        int hammingDistance = 0;
        for (List<Integer> indices : components.values()) {
            
            // count source value frequencies in this component
            Map<Integer, Integer> freq = new HashMap<>();
            for (int i : indices) {
                freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
            }

            // Try to match each target value
            for (int i : indices) {
                int t = target[i];
                if (freq.getOrDefault(t, 0) > 0) {
                    // Match found — consume it
                    freq.put(t, freq.get(t) - 1);
                } else {
                    // No match available
                    hammingDistance++;
                }
            }
        }
        return hammingDistance;
    }
}