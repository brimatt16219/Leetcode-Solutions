class Solution {

    private TrieNode root;

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.endOfWord = true;
    }

    public int prefixLength(String prefix) {
        int length = 0;
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                break;
            }
            length++;
            cur = cur.children.get(c);
        }
        System.out.println("Length of : " + prefix + " is " + length); 
        return length;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        root = new TrieNode();
        
        for (int num : arr1) {
            insert(String.valueOf(num));
        }

        int max = 0;
        for (int num : arr2) {
            int length = prefixLength(String.valueOf(num));
            max = Math.max(max, length);
        }
        return max;
    }
}

public class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
}