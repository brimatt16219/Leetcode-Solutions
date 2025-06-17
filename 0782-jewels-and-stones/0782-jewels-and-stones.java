class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        char[] arr = jewels.toCharArray();
        char[] arr2 = stones.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) count++;
        }
        return count;
    }
}