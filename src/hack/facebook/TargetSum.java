package hack.facebook;

import java.util.HashMap;
import java.util.Map;

/*
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3.
Output: 5
Explanation:

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.


Reference:
https://leetcode.com/problems/target-sum/discuss/97371/Java-Short-DFS-Solution
https://leetcode.com/problems/target-sum/discuss/97333/Java-simple-DFS-with-memorization
https://leetcode.com/problems/target-sum/discuss/97335/Short-Java-DP-Solution-with-Explanation
https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C++-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation

 */
public class TargetSum {
    private int result = 0;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return result;
        }

        helper(nums, S, 0, 0);

        return result;
    }

    private void helper(int[] nums, int target, int pos, long eval) {
        if (pos == nums.length) {
            if (target == eval) {
                result++;
            }
            return;
        }

        helper(nums, target, pos + 1, eval + nums[pos]);
        helper(nums, target, pos + 1, eval - nums[pos]);
    }

    // Optimization on DFS
    public int findTargetSumWays2(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return helper(nums, 0, 0, S, new HashMap<String, Integer>());
    }

    private int helper(int[] nums, int index, int sum, int target, Map<String, Integer> map) {
        String encoding = index + "->" + sum;

        if (map.containsKey(encoding)) {
            return map.get(encoding);
        }

        if (index == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        int curNum = nums[index];
        int add = helper(nums, index + 1, sum - curNum, target, map);
        int minus = helper(nums, index + 1, sum + curNum, target, map);
        map.put(encoding, add + minus);
        return add + minus;
    }

    // DP
    /*
    Merge answers of this thread:
    this is a classic knapsack problem
    in knapsack, we decide whether we choose this element or not
    in this question, we decide whether we add this element or minus it

    So start with a two dimensional array dp[i][j] which means the number of ways for first i-th element to reach a sum j

    we can easily observe that dp[i][j] = dp[i-1][j+nums[i]] + dp[i-1][j-nums[i],

    Another part which is quite confusing is return value, here we return dp[sum+S], why is that?
    because dp’s range starts from -sum --> 0 --> +sum
    so we need to add sum first, then the total starts from 0, then we add S

    Actually most of Sum problems can be treated as knapsack problem, hope it helps

    public int findTargetSumWays(int[] nums, int S) {

          int sum = 0;
          for(int n: nums){
            sum += n;
          }
          if (S < -sum || S > sum) { return 0;}

          int[][] dp = new int[nums.length + 1][ 2 * sum + 1];
          dp[0][0 + sum] = 1; // 0 + sum means 0, 0 means -sum,  check below graph
          for(int i = 1; i <= nums.length; i++){
            for(int j = 0; j < 2 * sum + 1; j++){

              if(j + nums[i - 1] < 2  * sum + 1) dp[i][j] += dp[i - 1][j + nums[i - 1]];
              if(j - nums[i - 1] >= 0) dp[i][j] += dp[i - 1][j - nums[i - 1]];
            }
          }
          return dp[nums.length][sum + S];
        }
     */
    public int findTargetSumWaysDp(int[] nums, int S) {
        int sum = 0;

        for (int n : nums) {
            sum += n;
        }

        if (S < -sum || S > sum) {
            return 0;
        }

        int[][] dp = new int[nums.length + 1][2 * S + 1];

        dp[0][0 + sum] = 1; // 0 + Sum means 0, 0 means -Sum,
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) {
                if (j + nums[i - 1] < 2 * sum + 1) {
                    dp[i][j] += dp[i - 1][j = nums[i - 1]];
                }

                if (j - nums[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][sum + S];
    }

}
