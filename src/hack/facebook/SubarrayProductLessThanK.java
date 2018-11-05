package hack.facebook;

/*
Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Note:

0 < nums.length <= 50000.
0 < nums[i] < 1000.
0 <= k < 10^6.
 */
public class SubarrayProductLessThanK {
    /*
     * Reference:
     * https://leetcode.com/problems/subarray-product-less-than-k/discuss/108861/JavaC%2B%2B-Clean-Code-with-Explanation
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;

        int count = 0;
        int product = 1;

        for (int i = 0, j = 0; j < nums.length; j++) {
            product *= nums[j];
            while (product >= k && i <= j) {
                product /= nums[i++];
            }
            count += (j - i + 1);
        }
        return count;
    }
}
