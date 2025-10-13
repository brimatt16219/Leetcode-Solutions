class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        int i = len % 2 == 0 ? len / 2 - 1 : len / 2;
        long firstHalf = Long.parseLong(n.substring(0, i + 1));

        List<Long> possible = new ArrayList<>();

        possible.add(palindrome(firstHalf, len % 2 == 0));
        possible.add(palindrome(firstHalf + 1, len % 2 == 0));
        possible.add(palindrome(firstHalf - 1, len % 2 == 0));
        possible.add((long) Math.pow(10, len - 1) - 1);
        possible.add((long) Math.pow(10, len) + 1);

        long diff = Long.MAX_VALUE, res = 0, nl = Long.parseLong(n);
        for (long l : possible) {
            if (l == nl) continue;
            if (Math.abs(l - nl) < diff) {
                diff = Math.abs(l - nl);
                res = l;
            }
            else if (Math.abs(l - nl) == diff) {
                res = Math.min(res, l);
            }
        }
        return String.valueOf(res);
    }

    private long palindrome(long left, boolean even) {
        // Convert half to palindrome
        long res = left;
        if (!even) left = left / 10;
        while (left > 0) {
            res = res * 10 + (left % 10);
            left /= 10;
        }
        return res;
    }
}