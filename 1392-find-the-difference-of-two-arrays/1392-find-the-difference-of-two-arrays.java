class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> a = new HashSet<>(), b = new HashSet<>();
        for (int x : nums1) a.add(x);
        for (int x : nums2) b.add(x);

        List<Integer> onlyInA = new ArrayList<>();
        for (int x : a) {
            if (!b.contains(x)) {
                onlyInA.add(x);
            }
        }

        List<Integer> onlyInB = new ArrayList<>();
        for (int x : b) {
            if (!a.contains(x)) {
                onlyInB.add(x);
            }
        }

        List<List<Integer>> sol = new ArrayList<>();
        sol.add(onlyInA);
        sol.add(onlyInB);

        return sol;


    }
}