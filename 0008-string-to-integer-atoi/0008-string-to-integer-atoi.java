class Solution {
    public int myAtoi(String s) {
        s = s.stripLeading();

        if (s.length() == 0) {
            return 0;
        }
        int i = 0;
        int sign = 1;
        if (s.charAt(i) == '+') {
            i++;
        }
        else if (s.charAt(i) == '-') {
            i++;
            sign = -1;
        }

        long parsed = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) break;
            
            parsed = parsed * 10 + (c - '0');
            
            if (parsed * sign >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (parsed * sign <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            
            i++;
        }
        parsed *= sign;

        return (int) parsed;
    }
}