class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int maxLen = Math.min(str1.length(), str2.length());

        for (int len = maxLen; len > 0; len--) {
            
            if (str1.length() % len == 0 && str2.length() % len == 0) {
                String candidate = str1.substring(0, len);
                if (divides(str1, candidate) && divides(str2, candidate)) {
                    return candidate;
                }
            }
        }
        return ""; 
    }

    private boolean divides(String s, String x) {
        int chunk = x.length();
        if (s.length() % chunk != 0) return false;

        for (int i = 0; i < s.length(); i += chunk) {
            if (!s.substring(i, i + chunk).equals(x)) {
                return false;
            }
        }
        return true;
    }
}
