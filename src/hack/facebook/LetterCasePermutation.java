package hack.facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length at most 12.
S will consist only of letters or digits.

Reference:
https://leetcode.com/problems/letter-case-permutation/discuss/115485/Java-Easy-BFS-DFS-solution-with-explanation
 */
public class LetterCasePermutation {
    //DFS
    public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        helper(S, res, 0);
        return res;
    }

    private void helper(String s, List<String> res, int index) {
        if (index == s.length()) {
            res.add(s);
            return;
        }

        if (Character.isDigit(s.charAt(index))) {
            helper(s, res, index + 1);
            return;
        }

        char[] chars = s.toCharArray();
        chars[index] = Character.toLowerCase(chars[index]);
        helper(String.valueOf(chars), res, index + 1);

        chars[index] = Character.toUpperCase(chars[index]);
        helper(String.valueOf(chars), res, index + 1);
    }

    //BFS
    public List<String> letterCasePermutationBFS(String S) {
        if (S == null) {
            return new ArrayList<>();
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(S);

        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) {
                continue;
            }

            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();

                char[] chars = cur.toCharArray();
                chars[i] = Character.toLowerCase(chars[i]);
                queue.offer(String.valueOf(chars));

                chars[i] = Character.toUpperCase(chars[i]);
                queue.offer(String.valueOf(chars));
            }
        }

        return new ArrayList<>(queue);
    }
}
