package hack.facebook;

import java.util.Stack;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    characterStack.push(')');
                    break;
                case '[':
                    characterStack.push(']');
                    break;
                case '{':
                    characterStack.push('}');
                    break;
                default:
                    if (characterStack.isEmpty() || characterStack.pop() != c) {
                        return false;
                    }
            }
        }
        return characterStack.isEmpty();
    }
}
