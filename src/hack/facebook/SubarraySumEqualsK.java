package hack.facebook;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1); //key: preSum, value: frequency

        for (int num : nums) {
            sum += num;
            count += preSum.getOrDefault(sum - k, 0);
            // it means there is some sum value v between 0 and x, which makes sum of array [x + 1 to i] == k
            // the frequency is the number of x
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
