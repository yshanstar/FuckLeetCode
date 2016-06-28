package hack.linkedin;

/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		} else if (nums.length == 1) {
			return (nums[0] == target) ? 0 : -1;
		}

		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			}

			if (nums[left] <= nums[mid]) {
				if (target < nums[mid] && target >= nums[left]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (target > nums[mid] && nums[right] >= target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

		return -1;
	}
}
