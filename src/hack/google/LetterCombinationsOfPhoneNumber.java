package hack.google;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOfPhoneNumber {
	char[][] map = new char[][] { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' },
			{ 'w', 'x', 'y', 'z' } };

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();

		if (digits == null || digits.isEmpty()) {
			return res;
		}

		StringBuilder sb = new StringBuilder();
		helper(digits, 0, sb, res);

		return res;
	}

	private void helper(String digits, int idx, StringBuilder sb, List<String> res) {
		if (idx == digits.length()) {
			res.add(sb.toString());
			return;
		}

		int index = digits.charAt(idx) - '0';

		for (char c : map[index]) {
			sb.append(c);
			helper(digits, idx + 1, sb, res);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
