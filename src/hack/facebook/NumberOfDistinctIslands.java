package hack.facebook;

import java.util.HashSet;
import java.util.Set;

/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:
11000
11000
00011
00011
Given the above grid map, return 1.
Example 2:
11011
10000
00001
11011
Given the above grid map, return 3.

Notice that:
11
1
and
 1
11
are considered different island shapes, because we do not consider reflection / rotation.
Note: The length of each dimension in the given grid does not exceed 50.
 */
public class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, "O");
                    set.add(sb.toString());
                }
            }
        }

        return set.size();
    }

    private void dfs(int[][] grib, int row, int col, StringBuilder sb, String direction) {
        if (row < 0 || row >= grib.length || col < 0 || col >= grib[row].length || grib[row][col] != 1) {
            return;
        }
        sb.append(direction);
        grib[row][col] = 0;
        dfs(grib, row - 1, col, sb, "U");
        dfs(grib, row + 1, col, sb, "D");
        dfs(grib, row, col - 1, sb, "L");
        dfs(grib, row, col + 1, sb, "R");
        sb.append("B");
    }
}
