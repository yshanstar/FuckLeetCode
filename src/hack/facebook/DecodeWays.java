package hack.facebook;

import java.util.Arrays;

/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.
 */
public class DecodeWays {
	public int numDecodings(String s) {
		if (s == null || s.isEmpty() || s.charAt(0) - '0' == 0) {
			return 0;
		}

		int[] dp = new int[2];
		Arrays.fill(dp, 1);

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int tmp = 0;

			if (c != '0') {
				tmp = dp[1];
			}

			if (i > 0) {
				int a = Integer.parseInt(s.substring(i - 1, i + 1));
				if (s.charAt(i - 1) != '0' && a <= 26 && a >= 1) {
					tmp += dp[0];
				}
			}

			dp[0] = dp[1];
			dp[1] = tmp;
		}

		return dp[1];
	}

	public int numDecodings2(String s) {
		if (s == null || s.isEmpty() || s.charAt(0) - '0' == 0) {
			return 0;
		}

		int[] waysToDecode = new int[s.length() + 1];
		waysToDecode[0] = 1;
		waysToDecode[1] = 1;

		for (int i = 1; i < s.length(); i++) {
			int cur = s.charAt(i) - '0';
			int prev = s.charAt(i - 1) - '0';

			if (prev == 0 && cur == 0 || (cur == 0 && (prev * 10 + cur > 26))) {
				return 0;
			}

			else if (prev == 0 || (prev * 10 + cur > 26)) {
				waysToDecode[i + 1] = waysToDecode[i];
			}

			else if (cur == 0) {
				waysToDecode[i + 1] = waysToDecode[i - 1];
			}

			else {
				waysToDecode[i + 1] = waysToDecode[i] + waysToDecode[i - 1];
			}
		}

		return waysToDecode[s.length()];

	}
}
