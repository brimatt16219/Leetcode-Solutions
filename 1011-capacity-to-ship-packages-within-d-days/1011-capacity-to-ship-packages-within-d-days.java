class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;
        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }
        int res = r;
        while (l <= r) {
            int cap = (r + l) / 2;
            if (canShip(weights, days, cap)) {
                res = Math.min(cap, res);
                r = cap - 1;
            }
            else {
                l = cap + 1;
            }
        }
        return res;
    }

    private boolean canShip(int[] weights, int days, int cap) {
        int ship = 1;
        int curCap = cap;
        for (int w : weights) {
            if (curCap - w < 0) {
                ship++;
                if (ship > days) {
                    return false;
                }
                curCap = cap;
            }
            curCap -= w;
        }
        return true;
    }
}