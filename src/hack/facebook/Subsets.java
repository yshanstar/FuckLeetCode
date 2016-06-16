package hack.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		res.add(new ArrayList<Integer>());
		Arrays.sort(nums);

		return helper(nums, 0, res);
	}

	private List<List<Integer>> helper(int[] nums, int idx, List<List<Integer>> tmpRes) {
		if (idx == nums.length) {
			return tmpRes;
		}

		List<List<Integer>> newRes = new ArrayList<List<Integer>>(tmpRes);
		for (List<Integer> tmpList : tmpRes) {
			List<Integer> list = new ArrayList<Integer>(tmpList);
			list.add(nums[idx]);
			newRes.add(list);
		}

		return helper(nums, idx + 1, newRes);
	}

	/*
	 * Subsets solution backtrack
	 */
	public List<List<Integer>> subsetsBacktrack(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return res;
		}

		Arrays.sort(nums);
		helperBacktrack(res, 0, nums, new ArrayList<Integer>());
		return res;
	}

	private void helperBacktrack(List<List<Integer>> res, int idx, int[] nums, List<Integer> tmpList) {
		res.add(new ArrayList<Integer>(tmpList));

		for (int i = idx; i < nums.length; i++) {
			tmpList.add(nums[i]);
			helperBacktrack(res, i + 1, nums, tmpList);
			tmpList.remove(tmpList.size() - 1);
		}
	}
}
