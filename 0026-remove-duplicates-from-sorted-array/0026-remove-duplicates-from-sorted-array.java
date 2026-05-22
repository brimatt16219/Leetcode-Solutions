class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return set.size();
    }
}