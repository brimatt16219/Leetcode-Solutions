class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
        for (int i = triangle.size() - 1; i > 0; i--) {
            for (int j = 0; j < triangle.get(i - 1).size(); j++) {
                // System.out.println(" i: " + i + " j: " + j);
                // System.out.println("comparing " + triangle.get(i).get(j) + " and " + triangle.get(i).get(j + 1));
                triangle.get(i - 1).set(j, min(triangle.get(i).get(j), triangle.get(i).get(j + 1)) + triangle.get(i - 1).get(j));
            }
        }

        return triangle.get(0).get(0);
    }

    private int min(int a, int b) {
        return (a < b) ? a : b;
    }
}