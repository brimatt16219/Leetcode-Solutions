class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> buckets = new HashMap<>();

        for (String s : strs) {

            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a'] ++;
            }

            StringBuilder keyBuilder = new StringBuilder();

            for (int freq : count) {
                keyBuilder.append('#').append(freq);
            }

            String key = keyBuilder.toString();
            
            buckets
                .computeIfAbsent(key, k -> new ArrayList<>())
                .add(s);
        }

        return new ArrayList<>(buckets.values());
    }
}