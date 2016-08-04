package hack.google;

import java.util.ArrayList;
import java.util.List;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();

		if (n <= 0) {
			return res;
		}

		helper(res, 0, 0, n, "");

		return res;
	}

	private void helper(List<String> res, int l, int r, int n, String tmp) {
		if (l > n || r > n) {
			return;
		}

		if (r == n) {
			res.add(tmp);
		}

		if (n == 1) {
			res.add("()");
			return;
		}

		helper(res, l + 1, r, n, tmp + "(");
		if (l > r) {
			helper(res, l, r + 1, n, tmp + ")");
		}
	}
}
