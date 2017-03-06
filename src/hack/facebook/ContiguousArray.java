package hack.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * <p>
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int[] diff = new int[nums.length + 1]; // diff[] is used for "count of 1s minus count of 0s"

        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 0);

        for (int i = 1; i <= nums.length; i++) {
            diff[i] = diff[i - 1] + (nums[i - 1] == 0 ? -1 : 1);

            if (!countMap.containsKey(diff[i])) {
                countMap.put(diff[i], i);
            } else {
                res = Math.max(res, i - countMap.get(diff[i]));
            }

        }

        return res;
    }
}
