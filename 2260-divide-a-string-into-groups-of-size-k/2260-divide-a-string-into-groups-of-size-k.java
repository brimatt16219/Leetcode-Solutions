class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> sol = new ArrayList<String>();

        for (int i = 0; i < s.length(); i += k) {
            if (s.length() - i >= k) {
                sol.add(s.substring(i, i + k));
            }
            else {
                String t = s.substring(i);

                for (int j = 0; j <  k - (s.length() % k); j++) {
                    t += fill;
                }

                sol.add(t);
                
            }
        }

        
        return sol.toArray(new String[0]);
    }
}