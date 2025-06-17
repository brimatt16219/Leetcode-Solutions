class Solution {
    public int tribonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 1;
        int d = a + b + c;
        if (n == 0) return a;
        if (n == 1) return b;
        if (n == 2) return c;
        if (n == 3) return d;
        for (int i = 0; i < n - 3; i++) {
            a = b;
            b = c;
            c = d;
            d = a + b + c;
        }
        return d;
    }
}