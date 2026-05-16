class Solution {
    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        return isLowerPalindrome(lower);
    }

    boolean isLowerPalindrome(String s) {
        int r = s.length() - 1;
        for (int l = 0; l < s.length() / 2; l++) {
            if (s.charAt(l) != s.charAt(r)) return false;
            r --;
        }
        return true;
    }
}