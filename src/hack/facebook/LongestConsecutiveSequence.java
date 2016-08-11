package hack.facebook;

import java.util.HashSet;
import java.util.Set;

/*
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		Set<Integer> set = new HashSet<Integer>();
		for (int n : nums) {
			set.add(n);
		}

		int res = 0;

		for (int n : nums) {
			if (!set.contains(n)) {
				continue;
			}
			set.remove(n);

			int tmp = 1;
			int left = n - 1;
			while (set.contains(left)) {
				tmp++;
				set.remove(left);
				left--;
			}

			int right = n + 1;
			while (set.contains(right)) {
				tmp++;
				set.remove(right);
				right++;
			}

			res = Math.max(res, tmp);
		}

		return res;
	}

}
