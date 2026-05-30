class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int bestIdx = -1;
    }

    TrieNode root = new TrieNode();

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int n = wordsContainer.length;
        int[] lengths = new int[n];
        for (int i = 0; i < n; i++) {
            lengths[i] = wordsContainer[i].length();
        }

        for (int i = 0; i < n; i++) {
            insert(wordsContainer[i], i, lengths);
        }

        int[] res = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            res[i] = query(wordsQuery[i], lengths);
        }
        return res;
    }

    public void insert(String word, int idx, int[] lengths) {
        TrieNode cur = root;

        if (cur.bestIdx == -1 || lengths[idx] < lengths[cur.bestIdx]) {
            cur.bestIdx = idx;
        }

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
            
            if (cur.bestIdx == -1 || lengths[idx] < lengths[cur.bestIdx]) {
                cur.bestIdx = idx;
            }
        }
    }

    public int query(String word, int[] lengths) {
        TrieNode cur = root;
        int best = cur.bestIdx;

        for (int i = word.length() - 1; i >=0; i--) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                break;
            }
            cur = cur.children[c];
            best = cur.bestIdx;
        }
        return best;
    }
}