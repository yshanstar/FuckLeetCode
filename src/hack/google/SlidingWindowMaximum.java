package hack.google;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Therefore, return the max sliding window as [3,3,5,5,6,7].

 Note: 
 You may assume k is always valid, ie: 1 <= k <= input array's size for non-empty array.
 */

/**
 * https://leetcode.com/discuss/103542/important-talk-about-solution-brute-force
 * -deque-method-java
 **/

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 0) {
			return new int[0];
		}

		int[] res = new int[nums.length - k + 1];
		int idx = 0;

		Deque<Integer> dq = new LinkedList<Integer>();

		for (int i = 0; i < k; i++) {
			while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
				dq.removeLast();
			}

			dq.addLast(i);
		}

		for (int i = k; i < nums.length; i++) {
			res[idx++] = nums[dq.peekFirst()];

			while (!dq.isEmpty() && dq.peekFirst() <= (i - k)) {
				dq.pollFirst();
			}

			while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
				dq.pollLast();
			}

			dq.offerLast(i);
		}

		res[idx++] = nums[dq.peekFirst()];

		return res;
	}
}
