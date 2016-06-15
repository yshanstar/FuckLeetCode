package hack.facebook;

/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
	public static String minWindow(String s, String t) {
		if (t == null || t.isEmpty()) {
			return "";
		}

		int[] needToFind = new int[256];
		int[] hasFind = new int[256];

		for (char c : t.toCharArray()) {
			needToFind[c]++;
		}

		String res = "";
		int found = 0;

		for (int start = 0, end = 0; end < s.length(); end++) {
			char c = s.charAt(end);
			if (needToFind[c] == 0) {
				continue;
			}

			hasFind[c]++;
			if (hasFind[c] <= needToFind[c]) {
				found++;
			}

			if (found == t.length()) {
				char startC = s.charAt(start);
				while (needToFind[startC] == 0 || hasFind[startC] > needToFind[startC]) {
					if (hasFind[startC] > needToFind[startC]) {
						hasFind[startC]--;
					}
					start++;
					startC = s.charAt(start);
				}
				int length = end - start + 1;
				if (res.isEmpty() || res.length() > length) {
					res = s.substring(start, end + 1);
				}
			}
		}

		return res;
	}
}
