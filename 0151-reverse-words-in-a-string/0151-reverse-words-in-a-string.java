class Solution {
    public String reverseWords(String s) {
        
    
        String[] words = s.trim().split("\\s+");


        String sol = "";

        for (int i = words.length - 1; i >= 0; i--) {
            if (i > 0) sol += words[i] + " ";
            else sol += words[i];
        }
        return sol;
    }
}