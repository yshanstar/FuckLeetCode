package hack.google;

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
		Set<Integer> numSet = new HashSet<Integer>();

		for (int num : nums) {
			numSet.add(num);
		}

		int max = 1;
		for (int n : nums) {
			int left = n - 1;
			int right = n + 1;
			int count = 1;

			while (numSet.contains(left)) {
				numSet.remove(left--);
				count++;
			}

			while (numSet.contains(right)) {
				numSet.remove(right++);
				count++;
			}

			max = Math.max(max, count);
		}

		return max;
	}
}
