package hack.google;

import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.isEmpty()) {
			return false;
		}

		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			switch (c) {
			case '(':
			case '{':
			case '[':
				stack.push(c);
				break;
			case ')':
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
				break;
			case '}':
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
				break;
			case ']':
				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
				break;
			default:
				return false;
			}
		}

		return stack.isEmpty();
	}
}
