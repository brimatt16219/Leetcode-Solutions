class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        Arrays.sort(skill);
        int r = n - 1;
        int l = 0;
        int target = skill[l] + skill[r];
        long chemistry = 0;
        while (l < r) {
            int val = skill[l] + skill[r];
            if (val != target) return -1;
            chemistry += skill[l] * skill[r];
            l++;
            r--;
        }
        return chemistry;
    }
}