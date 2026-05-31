class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        
        long m = mass;
        for (int a : asteroids) {
            if (m < (long) a) {
                return false;
            }
            m += (long) a;
        }
        return true;
    }
}