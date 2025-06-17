class Solution {
    public String replaceDigits(String s) {
        char[] letters = s.toCharArray();
        String sol = "";

        for (int i = 1; i < letters.length; i+=2) {
            sol += letters[i - 1];
            int num = Character.getNumericValue(letters[i]);
            //System.out.println(num);
            sol += (char)(letters[i - 1] + num);
        }
        if (s.length() % 2 == 1) {
            sol += letters[letters.length - 1];
        }
        return sol;
    }
}