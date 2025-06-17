class Solution {
    public String mergeAlternately(String word1, String word2) {
        System.out.println(word1 + " " + word2);
        if (word1.length() == 0) return word2;
        if (word2.length() == 0) return word1;
        System.out.println("second: " + word1 + " " + word2);
        System.out.println("added:" + word1.substring(0,1) + word2.substring(0,1) + " new: " + word1.substring(1) + " " + word2.substring(1));
        return word1.substring(0,1) + word2.substring(0,1) + mergeAlternately(word1.substring(1), word2.substring(1));
    }
}