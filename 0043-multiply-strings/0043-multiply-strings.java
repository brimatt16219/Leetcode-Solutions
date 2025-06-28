class Solution {
    public String multiply(String num1, String num2) {
        
        // Check zero
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        // The product of two numbers of length n1 and n2 can be at most n1+n2 digits
        int n1 = num1.length(), n2 = num2.length();
        int[] res = new int[n1 + n2];

        // multiply each digit of num1 by each digit of num2
        // do from right to left
        for (int i = n1 - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';
            for (int j = n2 - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';

                int mul = d1 * d2;

                // positions in res[] for two-digit result:
                // (i + j) holds the carry
                // (i + j + 1) holds the unit digit
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;

        // skip leading zeroes
        while (idx < res.length && res[idx] == 0) { 
            idx ++;
        }
        for (; idx < res.length; idx++) {
            sb.append(res[idx]);
        }
        return sb.toString();
    }
}