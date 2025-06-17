class Solution {

    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public boolean isHappy(int n) {
        map.clear();
        return solveIt(n, 0);
    }

    boolean solveIt(int n, int k) {
        if (n == 1) return true;

        
        if (map.containsKey(n)) return false;
        map.put(n, k);
        
        int sum = 0;
        while (n > 0) {
            sum += Math.pow((n % 10), 2);
            n /= 10;
        }
        System.out.println(sum);
        return solveIt(sum, k + 1);
    }
}