class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        int[] res = new int[A.length];
        int count = 0;
        for (int i = 0; i < res.length; i++) {
            set1.add(A[i]);
            set2.add(B[i]);
            if (set2.contains(A[i])) {
                count++;
            }
            if (set1.contains(B[i]) && A[i] != B[i]) {
                count++;
            }
            res[i] = count;
        }
        return res;
    }
}