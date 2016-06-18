package hack.google;

/*
 * A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] != num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -infiniti.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int low = 0;
		int high = nums.length - 1;
		int mid = (low + high) / 2;

		while (low < high) {
			// This means the candidate peak can be between low and mid
			// mid itself is included since it is also possible to be a peak
			if (nums[mid] > nums[mid + 1]) {
				high = mid;
			} else {
				// This means the candidate peak can be between mid and high
				// where mid itself is excluded since it is smaller than mid + 1
				low = mid + 1;
			}
			mid = (low + high) / 2;
		}

		return mid;
	}
}
