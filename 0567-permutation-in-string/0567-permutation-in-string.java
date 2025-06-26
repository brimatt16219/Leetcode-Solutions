class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int n1 = s1.length(), n2 = s2.length();

        if (n1 > n2) return false;

        int[] s1Count = new int[26], s2Count = new int[26];
        for (int i = 0; i < n1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) matches ++;
        }

        for (int left = 0, right = n1; right < n2; left++, right++) {
            if (matches == 26) return true;

            int indexAdd = s2.charAt(right) - 'a';
            s2Count[indexAdd] ++;
            if (s2Count[indexAdd] == s1Count[indexAdd]) 
                matches ++;
            else if (s2Count[indexAdd] - 1 == s1Count[indexAdd])
                matches --;

            int indexRemove = s2.charAt(left) - 'a';
            s2Count[indexRemove] --;
            if (s2Count[indexRemove] == s1Count[indexRemove]) 
                matches ++;
            else if (s2Count[indexRemove] + 1 == s1Count[indexRemove])
                matches --;
        }
        return matches == 26;
    }
}