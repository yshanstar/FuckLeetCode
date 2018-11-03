package hack.facebook;

import java.util.HashSet;

/*
Given an array with n integers, you need to find if there are triplets (i, j, k) which satisfies following conditions:

0 < i, i + 1 < j, j + 1 < k < n - 1
Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
where we define that subarray (L, R) represents a slice of the original array starting from the element indexed L to the element indexed R.
Example:
Input: [1,2,1,2,1,2,1]
Output: True
Explanation:
i = 1, j = 3, k = 5.
sum(0, i - 1) = sum(0, 0) = 1
sum(i + 1, j - 1) = sum(2, 2) = 1
sum(j + 1, k - 1) = sum(4, 4) = 1
sum(k + 1, n - 1) = sum(6, 6) = 1
Note:
1 <= n <= 2000.
Elements in the given array will be in range [-1,000,000, 1,000,000].

 */
public class SplitArrayWithEuqalSum {
    /*
    Reference:https://leetcode.com/problems/split-array-with-equal-sum/discuss/101484/Java-solution-DFS
     */
    public boolean splitArrayDFS(int[] nums) {
        if (nums == null || nums.length < 7) {
            return false;
        }

        int sum = 0;
        int target = 0;
        for (int num : nums) {
            sum += num;
        }

        for (int i = 1; i + 5 < nums.length; i++) {
            if (i != 1 && nums[i - 1] == 0 && nums[i] == 0) continue;
            target += nums[i - 1];
            if (dfs(nums, i + 1, target, sum - target - nums[i], 1)) return true;
        }
        return false;
    }

    private boolean dfs(int nums[], int start, int target, int left, int depth) {
        if (depth == 3) {
            return left == target;
        }

        int subSum = 0;
        for (int j = start + 1; j < nums.length; j++) {
            subSum += nums[j - 1];
            if (subSum == target) {
                if (dfs(nums, j + 1, target, left - subSum - nums[j], depth + 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    /*
    https://leetcode.com/problems/split-array-with-equal-sum/discuss/101481/Simple-Java-solution-O(n2)
     */
    public boolean splitArray(int[] nums) {
        if (nums == null || nums.length < 7) {
            return false;
        }

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int idx = 1; idx < nums.length; idx++) {
            sum[idx] = sum[idx - 1] + nums[idx];
        }

        for (int midCut = 3; midCut < nums.length - 3; midCut++) {
            HashSet<Integer> set = new HashSet<>();

            for (int leftCut = 1; leftCut < midCut - 1; leftCut++) {
                // if the sum of leftCut == sum of from letfCut to middleCut, added into set to verify the last part
                int totalLeftSumBeforeCut = sum[leftCut - 1];
                int totalSumBetweenCuts = sum[midCut - 1] - sum[leftCut];
                if (totalLeftSumBeforeCut == totalSumBetweenCuts) {
                    set.add(totalSumBetweenCuts);
                }
            }

            for (int rightCut = midCut + 2; rightCut < nums.length - 1; rightCut++) {
                int totalSumBetweenCuts = sum[rightCut - 1] - sum[midCut];
                int totalSumRightCuts = sum[nums.length - 1] - sum[rightCut];
                if (totalSumRightCuts == totalSumBetweenCuts && set.contains(totalSumRightCuts)) {
                    return true;
                }
            }
        }

        return false;
    }
}
