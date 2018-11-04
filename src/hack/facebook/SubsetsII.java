package hack.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans, List<Integer> tmp, int[] nums, int start) {
        ans.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backTrack(ans, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);

            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
        }
    }
}
