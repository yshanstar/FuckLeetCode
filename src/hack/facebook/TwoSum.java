package hack.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		if (nums == null || nums.length < 2) {
			return result;
		}
		Map<Integer, List<Integer>> numsMap = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			if (!numsMap.containsKey(nums[i])) {
				numsMap.put(nums[i], new ArrayList<Integer>());
			}

			List<Integer> list = numsMap.get(nums[i]);
			list.add(i);
		}

		for (int i = 0; i < nums.length; i++) {
			if (numsMap.containsKey(target - nums[i])) {
				List<Integer> pos = numsMap.get(target - nums[i]);
				if (pos.size() == 1 && pos.get(0) != i) {
					result[0] = Math.min(pos.get(0), i);
					result[1] = Math.max(pos.get(0), i);
					return result;
				} else if (pos.size() > 1) {
					result[0] = Math.min(pos.get(1), i);
					result[1] = Math.max(pos.get(1), i);
					return result;
				}
			}
		}

		return result;
	}
}
