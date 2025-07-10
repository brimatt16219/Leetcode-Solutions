class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        // Use the first string as the “template”
        String first = strs[0];
        int n = first.length();
        
        for (int i = 0; i < n; i++) {
            char c = first.charAt(i);
            // Compare this character with the same position in all other strings
            for (int j = 1; j < strs.length; j++) {
                // If we've reached the end of strs[j] or there's a mismatch, return up to i
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return first.substring(0, i);
                }
            }
        }
        // If we never broke out, the entire first string is a common prefix
        return first;
    }
}