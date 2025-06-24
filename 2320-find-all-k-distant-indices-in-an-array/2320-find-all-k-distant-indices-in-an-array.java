class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        HashSet<Integer> sol = new HashSet<Integer>();

        List<Integer> keys = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) keys.add(i);
        }
        // System.out.println(keys);

        for (int num : keys) {
            for (int i = 0; i < nums.length; i++) {
                if (Math.abs(i - num) <= k) sol.add(i);
            }
        }
        // System.out.println(sol);
        List<Integer> list = new ArrayList<>(sol);
        Collections.sort(list);
        return list;
    }
}