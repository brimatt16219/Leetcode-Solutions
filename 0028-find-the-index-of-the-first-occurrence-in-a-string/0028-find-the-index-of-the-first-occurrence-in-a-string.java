class Solution {
    public int strStr(String haystack, String needle) {
        if (!haystack.contains(needle)) return -1;

        int i = 0;
        int k = needle.length();
        for (i = 0; i < haystack.length() - k + 1; i++) {
            if (haystack.substring(i, i + k).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}