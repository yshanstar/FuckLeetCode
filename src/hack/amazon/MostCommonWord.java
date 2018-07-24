package hack.amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

Example:
Input:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.


Note:

1 <= paragraph.length <= 1000.
1 <= banned.length <= 100.
1 <= banned[i].length <= 10.
The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
Different words in paragraph are always separated by a space.
There are no hyphens or hyphenated words.
Words only consist of letters, never apostrophes or other punctuation symbols.


Reference:
https://leetcode.com/problems/most-common-word/discuss/123854/C++JavaPython-Easy-Solution-with-Explanation

 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();

        /*
        \p{P} or \p{Punctuation}: any kind of punctuation character.
        \p{Pd} or \p{Dash_Punctuation}: any kind of hyphen or dash.
        \p{Ps} or \p{Open_Punctuation}: any kind of opening bracket.
        \p{Pe} or \p{Close_Punctuation}: any kind of closing bracket.
        \p{Pi} or \p{Initial_Punctuation}: any kind of opening quote.
        \p{Pf} or \p{Final_Punctuation}: any kind of closing quote.
        \p{Pc} or \p{Connector_Punctuation}: a punctuation character such as an underscore that
         */
        String[] words = paragraph.replaceAll("\\pP", " ").toLowerCase().split("\\s+");
        for (String word : words) {
            if (!ban.contains(word)) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }

        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
