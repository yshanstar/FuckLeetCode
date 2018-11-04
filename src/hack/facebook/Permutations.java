package hack.facebook;

import java.util.ArrayList;
import java.util.List;

/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]


Reference:
https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(ans, new ArrayList<>(), nums);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans, List<Integer> tmp, int[] nums) {
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int num : nums) {
            if (tmp.contains(num)) {
                continue;
            }
            tmp.add(num);
            backTrack(ans, tmp, nums);
            tmp.remove(tmp.size() - 1);
        }
    }
}
