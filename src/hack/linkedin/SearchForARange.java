package hack.linkedin;

import java.util.Arrays;

/*
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class SearchForARange {
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		Arrays.fill(result, -1);

		if (nums == null || nums.length == 0) {
			return result;
		} else if (nums.length == 1) {
			if (nums[0] == target) {
				Arrays.fill(result, 0);
			}
			return result;
		}

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		if (nums[left] != target) {
			return result;
		}

		result[0] = left;

		left = 0;
		right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		result[1] = (nums[right] == target) ? right : right - 1;

		return result;
	}
}
