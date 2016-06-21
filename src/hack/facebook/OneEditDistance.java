package hack.facebook;

/*
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
		if (s == null || t == null) {
			return false;
		}

		if (Math.abs(s.length() - t.length()) > 1) {
			return false;
		}

		if (s.length() == t.length()) {
			return isOneModify(s, t);
		}

		if (s.length() > t.length()) {
			return isOneDel(s, t);
		}

		return isOneDel(t, s);
	}

	private boolean isOneModify(String s, String t) {
		int diff = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				diff++;

				if (diff > 1) {
					return false;
				}
			}
		}

		return diff == 1;
	}

	private boolean isOneDel(String longer, String shorter) {
		for (int i = 0, j = 0; i < longer.length() && j < shorter.length(); i++, j++) {
			if (longer.charAt(i) != shorter.charAt(j)) {
				return longer.substring(i + 1).endsWith(shorter.substring(j));
			}
		}

		return true;
	}
}
