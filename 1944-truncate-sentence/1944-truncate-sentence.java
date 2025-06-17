class Solution {
    public String truncateSentence(String s, int k) {
        String[] arr = s.split(" ");
        String sol = "";

        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                sol += arr[i];
                break;
            }
            sol += arr[i] + " ";
        }
        return sol;
    }
}