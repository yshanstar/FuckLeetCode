package hack.facebook;

/*
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum >= s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int res = Integer.MAX_VALUE;
		int j = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum >= s) {
				res = Math.min(i - j + 1, res);

				while (sum >= s) {
					sum -= nums[j++];
					if (sum >= s) {
						res = Math.min(i - j + 1, res);
					}
				}
			}
		}

		if (res == Integer.MAX_VALUE) {
			return 0;
		}

		return res;
	}
}
