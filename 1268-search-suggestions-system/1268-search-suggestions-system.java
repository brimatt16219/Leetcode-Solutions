class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        int l = 0;
        int r = products.length - 1;
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            while (l <= r && (products[l].length() <= i || products[l].charAt(i) != c)) {
                l++;
            }
            while (l <= r && (products[r].length() <= i || products[r].charAt(i) != c)) {
                r--;
            }
            res.add(new ArrayList<>());
            int n = Math.min(3, r - l + 1);
            for (int j = 0; j < n; j++) {
                res.get(res.size() - 1).add(products[l + j]);
            }
        }
        return res;
    }
}