class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i > 0 && i < flowerbed.length - 1)) {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    n--;
                    i ++;
                }
            }
            else if (flowerbed[i] == 0 && i > 0) {
                if (flowerbed[i - 1] == 0) {
                    n--;
                    i ++;
                }
            }
            else if (flowerbed[i] == 0 && i < flowerbed.length - 1) {
                if (flowerbed[i + 1] == 0) {
                    n--;
                    i ++;
                }
            }
            else if (flowerbed.length == 1 && flowerbed[i] == 0) {
                n--;
                i ++;
            }
        }
        if (n > 0) return false;
        else return true;
    }
}