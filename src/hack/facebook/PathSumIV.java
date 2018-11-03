package hack.facebook;

/*
If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.

For each integer in this list:
The hundreds digit represents the depth D of this node, 1 <= D <= 4.
The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.
The units digit represents the value V of this node, 0 <= V <= 9.
Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. You need to return the sum of all paths from the root towards the leaves.

Example 1:
Input: [113, 215, 221]
Output: 12
Explanation:
The tree that the list represents is:
    3
   / \
  5   1

The path sum is (3 + 5) + (3 + 1) = 12.
Example 2:
Input: [113, 221]
Output: 4
Explanation:
The tree that the list represents is:
    3
     \
      1

The path sum is (3 + 1) = 4.
 */

import java.util.HashMap;
import java.util.Map;

public class PathSumIV {

    /*
    Reference:
    https://leetcode.com/problems/path-sum-iv/discuss/106892/Java-solution-Represent-tree-using-HashMap
    */
    int sum = 0;
    Map<Integer, Integer> tree = new HashMap<>();

    public int pathSum(int[] nums) {


        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int num : nums) {
            int key = getNodeKey(num);
            int value = getNodeValue(num);
            tree.put(key, value);
        }

        traverseTree(getNodeKey(nums[0]), 0);
        return sum;
    }

    private void traverseTree(int root, int preSum) {
        int level = root / 10;
        int pos = root % 10;
         /*
            Formula: For node xy? its left child is (x+1)(y*2-1)? and right child is (x+1)(y*2)?
        */
        int left = (level + 1) * 10 + pos * 2 - 1;
        int right = (level + 1) * 10 + pos * 2;

        int curSum = preSum + tree.get(root);

        if (!tree.containsKey(left) && !tree.containsKey(right)) {
            // this is leaf
            sum += curSum;
            return;
        }

        if (tree.containsKey(left)) {
            traverseTree(left, curSum);
        }

        if (tree.containsKey(right)) {
            traverseTree(right, curSum);
        }
    }


    private int getNodeValue(int num) {
        return num % 10;
    }

    private int getNodeKey(int num) {
        return num / 10;
    }
}
