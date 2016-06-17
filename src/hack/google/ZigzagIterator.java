package hack.google;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given two 1d vectors, implement an iterator to return their elements alternately.

 For example, given two 1d vectors:

 v1 = [1, 2]
 v2 = [3, 4, 5, 6]
 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

 Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

 The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

 [1,2,3]
 [4,5,6,7]
 [8,9]
 It should return [1,4,8,2,5,9,3,6,7].
 */
public class ZigzagIterator {
	Queue<Iterator<Integer>> queue;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		this.queue = new LinkedList<Iterator<Integer>>();
		if (v1.iterator() != null && v1.iterator().hasNext()) {
			this.queue.offer(v1.iterator());
		}

		if (v2.iterator() != null && v2.iterator().hasNext()) {
			this.queue.offer(v2.iterator());
		}
	}

	public int next() {
		if (hasNext()) {
			Iterator<Integer> cur = this.queue.poll();
			int res = cur.next();
			if (cur.hasNext()) {
				this.queue.offer(cur);
			}
			return res;
		}
		return Integer.MIN_VALUE;
	}

	public boolean hasNext() {
		if (this.queue.isEmpty()) {
			return false;
		}
		Iterator<Integer> cur = this.queue.peek();
		return cur.hasNext();
	}
}
