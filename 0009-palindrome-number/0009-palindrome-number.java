class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char[] digits = s.toCharArray();
        int length = s.length();
        int midpoint;
        if (length % 2 == 1) midpoint = length / 2 + 1;
        else midpoint = length;
        int i = 0;
        int j = length - 1;
        while (i < midpoint)
        {
            if (digits[i] != digits[j]) return false;
            i ++;
            j --;
        }
        return true;
    }
}