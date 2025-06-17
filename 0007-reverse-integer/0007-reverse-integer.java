class Solution {
    public int reverse(int x) {
        
        try {
            String s = Integer.toString(x);
            char[] digits = s.toCharArray();
            boolean isNeg = s.substring(0, 1).equals("-");
            if (isNeg) s = s.substring(1);
            String str = "";
            for (int i = digits.length - 1; i >= 0; i--)
            {
                if (Character.isDigit(digits[i]))
                {
                    str = str.concat(String.valueOf(digits[i]));
                }
            }
            int sol = Integer.parseInt(str);
            if (isNeg) return -sol;
            return sol;
        }
        catch (Exception e)
        {
            return 0;
        }
    }
}