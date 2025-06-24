class Solution {
    public int lengthOfLongestSubstring(String s) {

        // char[] arr = s.toCharArray();
        
        // int count = 0;
        // int max = count;
        // HashSet<Character> map = new HashSet<Character>();
        // for (int i = 0; i < arr.length; i++) {

        //     if (map.contains(arr[i])) count = 0;

        //     map.add(arr[i]);
        //     count ++;
        //     if (max < count) max = count;
        // }
        // System.out.println(map);
        // return max;

        // for (int i = 0; i < arr.length; i++) {
        //     // window from max to 0
        //     for (int j = 0; j <= i; j++) {
        //         // System.out.println("[" + j + " , " + (arr.length - i + j) + "]");
        //         // System.out.println("testing " + s.substring(j, arr.length - i + j));
        //         if (isValid(s.substring(j, arr.length - i + j))) return Math.abs(arr.length - i);
        //     }
        // }
        // return 0;

        int left = 0;
        int max = 0;
        HashSet<Character> map = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            while(map.contains(s.charAt(i))) {
                map.remove(s.charAt(left));
                left++;
            }

            map.add(s.charAt(i));
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    boolean isValid(String s) {
        char[] arr = s.toCharArray();
        HashSet<Character> map = new HashSet<Character>();
        for (int i = 0; i < arr.length; i++) {

            if (map.contains(arr[i])) return false;

            map.add(arr[i]);
        }
        return true;
    }
}