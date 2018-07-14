package hack.facebook;

import java.util.Arrays;

/*
Given an unsorted array of integers, find the number of longest increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:
Input: [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.

Reference:
https://leetcode.com/problems/number-of-longest-increasing-subsequence/discuss/107293/JavaC++-Simple-dp-solution-with-explanation
https://leetcode.com/problems/number-of-longest-increasing-subsequence/solution/

 */
public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;

        int[] maxLen = new int[n]; // maxLen[i]: the length of the Longest Increasing Subsequence which ends with nums[i].
        int[] counts = new int[n]; // the number of the Longest Increasing Subsequence which ends with nums[i].
        Arrays.fill(counts, 1);
        Arrays.fill(maxLen, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (maxLen[i] <= maxLen[j]) {
                        maxLen[i] = maxLen[j] + 1;
                        counts[i] = counts[j];
                    } else if (maxLen[i] == maxLen[j] + 1) {
                        counts[i] += counts[j];
                    }
                }
            }
        }

        int longest = 0, ans = 0;
        for (int length : maxLen) {
            longest = Math.max(longest, length);
        }

        for (int i = 0; i < n; ++i) {
            if (maxLen[i] == longest) {
                ans += counts[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        NumberOfLongestIncreasingSubsequence instance = new NumberOfLongestIncreasingSubsequence();

        int[] nums = {1, 3, 5, 4, 7};

        instance.findNumberOfLIS(nums);
    }
}
