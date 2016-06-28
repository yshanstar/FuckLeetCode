package hack.linkedin;

/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6
 */
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		if (nums == null || nums.length == 0) {
			return maxSum;
		}

		int tmpSum = 0;
		for (int i = 0; i < nums.length; i++) {
			tmpSum += nums[i];
			maxSum = Math.max(maxSum, tmpSum);
			if (tmpSum < 0) {
				tmpSum = 0;
			}
		}

		return maxSum;
	}
}
