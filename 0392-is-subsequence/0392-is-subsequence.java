class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        if (sarr.length == 0) return true;
        int counter = 0;
        for (int i = 0; i < tarr.length; i++) {
            // System.out.println("testing: " + sarr[counter] + " and " + tarr[i]);
            if (counter == sarr.length) return true;
            if (sarr[counter] == tarr[i]) {
                // System.out.println("is equal");
                counter ++;
            }
        }
        // System.out.println("counter is " + counter);
        return counter == sarr.length;
    }
}