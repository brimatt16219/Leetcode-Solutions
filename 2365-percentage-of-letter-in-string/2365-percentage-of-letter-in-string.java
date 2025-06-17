class Solution {
    public int percentageLetter(String s, char letter) {
        char[] letters = s.toCharArray();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (letters[i] == letter) count ++;
        }
        return (count * 100) / s.length();
    }
}