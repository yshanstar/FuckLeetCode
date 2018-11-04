package hack.facebook;

import java.util.ArrayList;
import java.util.List;

/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]

Reference:
https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        removeDFS(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    private void removeDFS(String s, List<String> ans, int last_left, int last_right, char[] parenthese) {
        for (int stack = 0, i = last_left; i < s.length(); i++) {
            if (s.charAt(i) == parenthese[0]) {
                stack++;
            }
            if (s.charAt(i) == parenthese[1]) {
                stack--;
            }
            if (stack >= 0) {
                continue;
            }
            for (int j = last_right; j <= i; ++j) {
                if (s.charAt(j) == parenthese[1] && (j == last_right || s.charAt(j - 1) != parenthese[1])) {
                    removeDFS(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, parenthese);
                }
            }
            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (parenthese[0] == '(') {
            removeDFS(reversed, ans, 0, 0, new char[]{')', '('});
        } else {
            ans.add(reversed);
        }
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses test = new RemoveInvalidParentheses();
        test.removeInvalidParentheses("()())()");
    }
}
