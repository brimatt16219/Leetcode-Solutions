class Solution {
    public boolean hasGroupsSizeX(int[] deck) {

        //cannot partition a deck with 1 or less cards
        if (deck.length < 2) return false;

        int first = deck[0];
        int max = 0;
        int recurrence = 0;

        //find how many occurances of the first card exist and find the highest value card
        for (int i = 0; i < deck.length; i ++) {
            if (deck[i] == first) recurrence ++;
            if (deck[i] > max) max = deck[i];
        }

        //make an array to store the count of  each of the cards
        int[] indexes = new int[max + 1];
        for (int i = 0; i < deck.length; i++) {
            indexes[deck[i]] ++;
        }
        
        //see if the card count is consistent with each card
        boolean allMod = false;
        for (int i = 2; i <= recurrence; i++) {
            allMod = true;
            System.out.println("Seeing if " + i + " can mod these indexes");
            for (int j = 0; j < indexes.length; j++) {
                if (indexes[j] % i != 0) allMod = false;
            }
            if (allMod) return true;
        }
        return allMod;
    }
}