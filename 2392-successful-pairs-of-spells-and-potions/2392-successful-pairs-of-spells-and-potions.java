class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        int[] arr = new int[spells.length];

        Arrays.sort(potions);

        for(int i = 0; i < arr.length; i++) {
            int left = 0;
            int right = potions.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                long product = (long)spells[i] * potions[mid];

                // Go left
                if (product >= success) right = mid - 1;
                else left = mid + 1;
            }
            arr[i] = potions.length - left;
        }
        return arr;
    }
}