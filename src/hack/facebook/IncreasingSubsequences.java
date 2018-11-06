package hack.facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .

Example:
Input: [4, 6, 7, 7]
Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
Note:
The length of the given array will not exceed 15.
The range of integer in the given array is [-100,100].
The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.

 */
public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        dfs(ans, nums, new ArrayList<>(), 0);

        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> tmp, int start) {
        if (tmp.size() >= 2) {
            ans.add(new ArrayList<>(tmp));
        }

        if (start >= nums.length) {
            return;
        }

        Set<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }

            if (tmp.size() == 0 || nums[i] >= tmp.get(tmp.size() - 1)) {
                used.add(nums[i]);
                tmp.add(nums[i]);
                dfs(ans, nums, tmp, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        IncreasingSubsequences test = new IncreasingSubsequences();
        int[] nums = new int[]{4, 6, 7, 7};
        test.findSubsequences(nums);
    }
}
