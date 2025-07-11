class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return fastPow(x, N);
    }

    double fastPow(double x, long n) {
        if (n < 0) return 1 / fastPow(x, -n);

        if (n == 0) return 1;

        double half = fastPow(x, n / 2);

        if (n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }
}