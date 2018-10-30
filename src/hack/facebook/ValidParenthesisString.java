package hack.facebook;

/*
Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].

Reference:
https://leetcode.com/problems/valid-parenthesis-string/discuss/107577/Short-Java-O(n)-time-O(1)-space-one-pass

 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int lowest = 0;
        int highest = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lowest++;
                highest++;
            } else if (s.charAt(i) == ')') {
                if (lowest > 0) {
                    lowest--;
                }
                highest--;
            } else {
                if (lowest > 0) {
                    lowest--;
                }
                highest++;
            }

            if (highest < 0) {
                return false;
            }
        }

        return lowest == 0;
    }
}
