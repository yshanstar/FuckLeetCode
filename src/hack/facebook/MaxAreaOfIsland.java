package hack.facebook;

/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.
 */
public class MaxAreaOfIsland {
    /*
     * Reference:
     * https://leetcode.com/problems/max-area-of-island/discuss/108533/JavaC%2B%2B-Straightforward-dfs-solution
     */
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                maxArea = Math.max(maxArea, areaOfIsland(grid, i, j));
            }
        }

        return maxArea;
    }

    private int areaOfIsland(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] != 1) {
            return 0;
        }

        grid[row][col] = 0;
        return 1 + areaOfIsland(grid, row + 1, col)
                + areaOfIsland(grid, row - 1, col)
                + areaOfIsland(grid, row, col - 1)
                + areaOfIsland(grid, row, col + 1);
    }
}
