class Solution {
    public int longestCommonSubsequence(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        char[] lettersA = a.toCharArray();
        char[] lettersB = b.toCharArray();

        int[][] sub = new int[lenA + 1][lenB + 1];

        //Set first column and row to zero
        for (int i = 0; i < sub.length; i++) { 
            sub[i][0] = 0;
        }
        for (int i = 1; i < sub[0].length; i++) {
            sub[0][i] = 0;
        } 

        for (int i = 1; i < sub.length; i++) { 
            for (int j = 1; j < sub[i].length; j++) { 

                //If the letters are equal, then add 1 and the previous sub problem
                if (lettersA[i - 1] == lettersB[j - 1]) {
                    sub[i][j] = 1 + sub[i - 1][j - 1];
                }
                //Otherwise, set the sub problem equal to the maximum sub problem of the previous row or column
                else {
                    sub[i][j] = max(sub[i - 1][j], sub[i][j - 1]);
                }
            }
        }

        return sub[sub.length - 1][sub[sub.length - 1].length - 1];
    }

    int max(int a, int b) {
        if (a < b) return b;

        return a;
    }
}