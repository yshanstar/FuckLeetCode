package hack.facebook;

/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int idx = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0 && idx == -1) {
				idx = i; // record the first 0;
			}

			if (nums[i] != 0 && idx != -1) {
				nums[idx] = nums[i];
				nums[i] = 0;
				idx++;
			}
		}
	}

	public void moveZeroes2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int idx = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				int tmp = nums[idx];
				nums[idx++] = nums[i];
				nums[i] = tmp;
			}
		}
	}
}
