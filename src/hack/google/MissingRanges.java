package hack.google;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class MissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<String>();
		if (nums == null || nums.length == 0) {
			res.add(new Range(lower, upper).toString());
			return res;
		}

		int prev;

		if (nums[0] - lower > 0) {
			res.add(new Range(lower, nums[0] - 1).toString());
			prev = nums[0];
		} else {
			prev = nums[0];
		}

		for (int cur : nums) {
			if (cur - prev > 1) {
				res.add(new Range(prev + 1, cur - 1).toString());
			}
			prev = cur;
		}

		if (upper > prev) {
			res.add(new Range(prev + 1, upper).toString());
		}

		return res;
	}

	class Range {
		public int lower;
		public int upper;

		public Range(int l, int h) {
			this.lower = l;
			this.upper = h;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(lower);
			if (lower != upper) {
				sb.append("->");
				sb.append(upper);
			}

			return sb.toString();
		}
	}
}
