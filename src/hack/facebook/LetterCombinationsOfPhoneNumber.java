package hack.facebook;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a digit string, return all possible letter combinations that the number could represent.
 A mapping of digit to letters (just like on the telephone buttons) is given below.
 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOfPhoneNumber {
	String[] dic = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();

		if (digits == null || digits.isEmpty()) {
			return res;
		}

		helper(res, digits, 0, "");

		return res;
	}

	private void helper(List<String> res, String digits, int idx, String tmp) {
		if (tmp.length() == digits.length()) {
			res.add(tmp);
			return;
		}

		int charIdx = digits.charAt(idx) - '0';
		for (char c : dic[charIdx].toCharArray()) {
			StringBuilder sb = new StringBuilder(tmp);
			sb.append(c);
			helper(res, digits, idx + 1, sb.toString());
		}
	}
}
