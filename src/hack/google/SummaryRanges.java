package hack.google;

import hack.util.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a sorted integer array without duplicates, return the summary of its ranges.

 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> ranges = new ArrayList<String>();
		if (nums == null || nums.length == 0) {
			return ranges;
		}

		Arrays.sort(nums);
		Interval interval = new Interval(nums[0], nums[0]);

		for (int i = 1; i < nums.length; i++) {
			int cur = nums[i];
			if (cur == interval.end + 1) {
				interval.end = cur;
			} else {
				ranges.add(interval.toString());
				interval = new Interval(cur, cur);
			}
		}

		ranges.add(interval.toString());
		return ranges;
	}
}
