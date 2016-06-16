package hack.facebook;

/*
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {
	public void sortColors(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int redIdx = 0;
		int blueIdx = nums.length - 1;

		for (int i = 0; i <= blueIdx; i++) {
			int cur = nums[i];

			if (cur == 0) {
				int tmp = nums[redIdx];
				nums[redIdx++] = cur;
				nums[i] = tmp;
			} else if (cur == 2) {
				int tmp = nums[blueIdx];
				nums[blueIdx--] = cur;
				nums[i] = tmp;
				i--;
			}
		}
	}
}
