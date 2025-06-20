class Solution {
    public int fib(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        
        int a = 0;
        int b = 1;
        int c = a + b;

        for (int i = 0; i < n - 2; i++) {
            a = b;
            b = c; 
            c = a + b;
        }

        return c;
    }
}