public class Solution {
    public IList<string> FullJustify(string[] words, int maxWidth) {
        var result = new List<string>();
        int i = 0;

        while (i < words.Length) {
            // Step 1: greedily find how many words fit on this line
            int j = i;
            int lineLen = 0; // total letters, no spaces
            while (j < words.Length && lineLen + words[j].Length + (j - i) <= maxWidth) {
                lineLen += words[j].Length;
                j++;
            }

            int wordCount = j - i;
            int gaps = wordCount - 1;
            var sb = new StringBuilder();

            // Step 3: last line or single word -> left-justify
            if (j == words.Length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    sb.Append(words[k]);
                    if (k < j - 1) sb.Append(' ');
                }
                sb.Append(' ', maxWidth - sb.Length); // pad right
            }
            // Step 2: fully justify
            else {
                int totalSpaces = maxWidth - lineLen;
                int each = totalSpaces / gaps;
                int extra = totalSpaces % gaps;

                for (int k = i; k < j; k++) {
                    sb.Append(words[k]);
                    if (k < j - 1) {
                        int spaces = each + ((k - i) < extra ? 1 : 0);
                        sb.Append(' ', spaces);
                    }
                }
            }

            result.Add(sb.ToString());
            i = j; // next line starts where this one ended
        }

        return result;
    }
}