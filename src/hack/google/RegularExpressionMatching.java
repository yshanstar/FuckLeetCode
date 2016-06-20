package hack.google;

/*
 * Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a")-> false
 isMatch("aa","aa") -> true
 isMatch("aaa","aa") -> false
 isMatch("aa", "a*") -> true
 isMatch("aa", ".*") -> true
 isMatch("ab", ".*") -> true
 isMatch("aab", "c*a*b") -> true
 */
public class RegularExpressionMatching {
	public static boolean isMatchDP(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}

		boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
		dp[0][0] = true;

		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*' && dp[i - 1][0]) {
				dp[i + 1][0] = true;
			}
		}

		/**
		 *	if p[j] == s[i], dp[j][i] = dp[j-1][i-1];
		 *	if p[j] == '.', dp[j][i] = dp[j-1][i-1]; 
		 *	if p[j] == '*'
		 *		a. if p[j-1] != '.' && p[j-1] != s[i], dp[j][i] = dp[j-2][i]
		 *		b. if p[j-1] == '.' || p[j-1] == s[i],
		 *				dp[j][i] = dp[j-1][i] // * is single a 
		 *				dp[j][i] = dp[j][i-1] // * is multiple a
		 *				dp[j][i] = dp[j-2][i] // * is empty    
		 **/
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < p.length(); j++) {
				if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
					dp[j + 1][i + 1] = dp[j][i];
				}
				if (p.charAt(j) == '*') {
					if (p.charAt(j - 1) != '.' && p.charAt(j - 1) != s.charAt(i)) {
						dp[j + 1][i + 1] = dp[j - 1][i + 1];
					} else {
						dp[j + 1][i + 1] = dp[j][i + 1] || dp[j + 1][i] || dp[j - 1][i + 1];
					}
				}
			}
		}
		
		return dp[p.length()][s.length()];
	}
	
	public static void main(String[] args) {
		System.out.println(isMatchDP("a", "aba"));
	}

	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}

		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.isEmpty() || (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.')) {
				return false;
			}

			return isMatch(s.substring(1), p.substring(1));
		}

		while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
			if (isMatch(s, p.substring(2))) {
				return true;
			}
			s = s.substring(1);
		}

		return isMatch(s, p.substring(2));
	}
}
