class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (char c : word.toCharArray()) {
            if (set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c))) {
                continue;
            }
            if (Character.isUpperCase(c) && set.contains(Character.toLowerCase(c))) {
                res++;
            }
            if (Character.isLowerCase(c) && set.contains(Character.toUpperCase(c))) {
                res++;
            }
            set.add(c);
            System.out.println(set);
        }
        return res;
    }
}