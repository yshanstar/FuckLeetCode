package hack.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import hack.util.Interval;

/*
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();

		if (intervals == null || intervals.isEmpty()) {
			return res;
		}

		if (intervals.size() == 1) {
			return intervals;
		}

		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});

		Interval cur = intervals.get(0);

		for (int i = 1; i < intervals.size(); i++) {
			Interval tmp = intervals.get(i);

			if (tmp.start > cur.end || cur.start > tmp.end) {
				res.add(cur);
				cur = tmp;
			} else {
				cur.start = Math.min(cur.start, tmp.start);
				cur.end = Math.max(cur.end, tmp.end);
			}
		}

		res.add(cur);

		return res;
	}
}
