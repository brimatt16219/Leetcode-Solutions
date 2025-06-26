class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1;
        int right = 0;

        for (int p : piles) {
            right = Math.max(right, p);
        }

        int k = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            long hours = 0;
            for (int p : piles) {
                // same as ceil
                hours += (p + mid - 1) / mid;
            }

            if (hours <= h) {
                k = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return k;
        
    }

}