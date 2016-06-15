package hack.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3) {
			return res;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					List<Integer> tmpList = new ArrayList<Integer>();
					tmpList.add(nums[i]);
					tmpList.add(nums[left]);
					tmpList.add(nums[right]);
					res.add(tmpList);
					left++;
					right--;

					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}

					while (left < right && nums[right] == nums[right + 1]) {
						right--;
					}

				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}

		return res;
	}
}
