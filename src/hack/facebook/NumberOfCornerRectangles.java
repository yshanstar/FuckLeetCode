package hack.facebook;

/*
Given a grid where each entry is only 0 or 1, find the number of corner rectangles.

A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle. Note that only the corners need to have the value 1. Also, all four 1s used must be distinct.



Example 1:

Input: grid =
[[1, 0, 0, 1, 0],
 [0, 0, 1, 0, 1],
 [0, 0, 0, 1, 0],
 [1, 0, 1, 0, 1]]
Output: 1
Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].


Example 2:

Input: grid =
[[1, 1, 1],
 [1, 1, 1],
 [1, 1, 1]]
Output: 9
Explanation: There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and one 3x3 rectangle.


Example 3:

Input: grid =
[[1, 1, 1, 1]]
Output: 0
Explanation: Rectangles must have four distinct corners.


Note:

The number of rows and columns of grid will each be in the range [1, 200].
Each grid[i][j] will be either 0 or 1.
The number of 1s in the grid will be at most 6000.


Reference:
https://leetcode.com/problems/number-of-corner-rectangles/discuss/110196/short-JAVA-AC-solution-(O(m2-*-n))-with-explanation.

 */

public class NumberOfCornerRectangles {
    public int countCornerRectangles(int[][] grid) {
        int result = 0;

        // Fix two rows first and then count by column
        for (int rowOne = 0; rowOne < grid.length - 1; rowOne++) {
            for (int rowTwo = rowOne + 1; rowTwo < grid.length; rowTwo++) {
                int counter = 0;
                for (int col = 0; col < grid[rowOne].length; col++) {
                    if (grid[rowOne][col] == 1 && grid[rowTwo][col] == 1) {
                        counter++;
                    }
                }
                if (counter > 0) {
                    // 1 + 2 + 3.... + (counter-1)
                    result += (1 + counter - 1) * (counter - 1) / 2;
                }
            }
        }

        return result;
    }
}
