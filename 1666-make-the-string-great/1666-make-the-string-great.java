class Solution {
    public String makeGood(String s) {
        return destroy(s);
    }

    String destroy(String s) {

        int index = indexOfAdjacent(s);
        System.out.println("index " + index);
        if (index == -1) return s;

        char[] words = s.toCharArray();
        String sol = "";

        //loop through words array, but only add the characters that arent the adjacent capitals
        
        for (int i = 0; i < words.length; i++) {
            if (i != index && i != index + 1) {
             sol = sol.concat(String.valueOf(words[i]));
            }
        }
        System.out.println("sol is " + sol);

        return destroy(sol);
    }

    //Find adjacent characters to uppercase characters
    //Return index of beginning of the two characters we will delete
    int indexOfAdjacent(String s) {
        char[] words = s.toCharArray();

        for (int i = 0; i < words.length; i++) {
            //See if char at i is uppercase
            if (Character.isUpperCase(words[i])) {
                //Check the left to the uppercase character, but only do this if i is 1 or greater
                if (i > 0) {
                    if (words[i - 1] == Character.toLowerCase(words[i])) {
                        return i - 1;
                    }
                }
                //Check the right to the upercase character, but only do this if i is less than words.length - 1
                if (i < words.length - 1) {
                    if (words[i + 1] == Character.toLowerCase(words[i])) {
                        return i;
                    }
                }
                
            }
        }

        return -1;// could not find word to delete
    }
}