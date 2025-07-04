class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int value = romanCharToInt(s.charAt(i));
            // If this is not the last character, and the next character
            // represents a larger value, then this one must be subtracted.
            if (i + 1 < n && value < romanCharToInt(s.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }
        
        return result;
    }
    
    // Helper to convert a single Roman character to its integer value
    private int romanCharToInt(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default:  return 0;
        }
    }
}