package hack.google;

/*
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:

 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        int duplicate = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    result++;
                    duplicate += checkOverlap(i, j, grid);
                }
            }
        }

        return result * 4 - duplicate;
    }

    private int checkOverlap(int i, int j, int[][] grid) {
        int overlap = 0;
        int newI = (i - 1 >= 0) ? (i - 1) : 0;
        if (newI != i && grid[newI][j] == 1) {
            overlap++;
        }
        newI = (i + 1 <= grid.length - 1) ? (i + 1) : grid.length - 1;
        if (newI != i && grid[newI][j] == 1) {
            overlap++;
        }

        int newJ = (j - 1 >= 0) ? (j - 1) : 0;
        if (newJ != j && grid[i][newJ] == 1) {
            overlap++;
        }

        newJ = (j + 1 <= grid[0].length - 1) ? (j + 1) : grid[0].length - 1;
        if (newJ != j && grid[i][newJ] == 1) {
            overlap++;
        }

        return overlap;
    }
}
