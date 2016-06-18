package hack.google;

/*
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */

/** https://leetcode.com/discuss/96183/java-1ms-ac-solution-with-explanation **/
public class WiggleSort {
	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}

		boolean greater = true;

		for (int i = 1; i < nums.length; i++) {
			if ((greater && nums[i] < nums[i - 1]) || (!greater && nums[i] > nums[i - 1])) {
				int tmp = nums[i];
				nums[i] = nums[i - 1];
				nums[i - 1] = tmp;
			}
			greater = !greater;
		}
	}
}
