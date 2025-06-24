class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<Character> chars = new ArrayList<Character>();
        List<Integer> indices = new ArrayList<Integer>();

        int row = 1;
        boolean down = true;
        for (int i = 0; i < s.length(); i++) {
            if (down) {
                chars.add(s.charAt(i));
                indices.add(row);
                row ++;
            }
            else {
                chars.add(s.charAt(i));
                indices.add(row);
                row --;
            }
            if (row == numRows || row == 1) {
                down = !down;
            }
        }
        String sol = "";
        for (int i = 1; i <= numRows; i++) {
            for (int j = 0; j < chars.size(); j++) {
                if (indices.get(j) == i) sol += chars.get(j);
            }
        }
        System.out.println(chars);
        System.out.println(indices);
        return sol;
    }
}