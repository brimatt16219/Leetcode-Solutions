class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                set.add(c);
            }
            
            if (Character.isLowerCase(c)) {
                map.put(c, i);  
            }
        }

        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (Character.isUpperCase(c)) {
                map.put(c, i);  
            }
        }

        for (char c : set) {
            char upper = Character.toUpperCase(c);
            char lower = Character.toLowerCase(c);
            if (map.containsKey(upper) && map.containsKey(lower)) {
                if (map.get(upper) > map.get(lower)) {
                    res++;
                }
            }
        }
        return res;
    }
}
