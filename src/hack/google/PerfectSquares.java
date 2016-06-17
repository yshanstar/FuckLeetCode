package hack.google;

import java.util.Arrays;

/*
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares {
	public int numSquares(int n) {
		if (n <= 0) {
			return 0;
		}
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		for (int i = 0; i <= n; i++) {
			int sqrt = (int) Math.sqrt(i);

			if (i == sqrt * sqrt) {
				dp[i] = 1;
				continue;
			}

			for (int j = 1; j <= sqrt; j++) {
				if (dp[i - j * j] + 1 < dp[i]) {
					dp[i] = dp[i - j * j] + 1;
				}
			}
		}

		return dp[n];
	}
}
