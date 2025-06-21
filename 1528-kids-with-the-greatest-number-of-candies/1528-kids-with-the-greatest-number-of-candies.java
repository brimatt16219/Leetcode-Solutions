class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        List<Boolean> sol = new ArrayList<Boolean>();
        int max = 0;
        for (int i : candies) {
            if (max < i) max = i;
        }

        for (int i : candies) {
            sol.add(i + extraCandies >= max);
        }

        return sol;
    }
}