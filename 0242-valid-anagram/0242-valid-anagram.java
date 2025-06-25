class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;
        
        HashMap<Character, Integer> a = new HashMap<>(), b = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            a.put(s.charAt(i), a.getOrDefault(s.charAt(i), 0) + 1);
            b.put(t.charAt(i), b.getOrDefault(t.charAt(i), 0) + 1);
        }

        return a.equals(b);
    }
}