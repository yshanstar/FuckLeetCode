package hack.facebook;

import hack.util.Point;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.



Example 1:

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: true

Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

Example 2:

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: false

Explanation: There is no way for the ball to stop at the destination.



Note:

There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
 */
public class TheMaze {

    /*
     * Reference:
     * https://leetcode.com/problems/the-maze/discuss/97071/Easy-understanding-Java-bfs-solution.
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null) {
            return false;
        }

        int row = maze.length;
        int col = maze[0].length;

        if (Arrays.equals(start, destination)) {
            return true;
        }

        boolean[][] visited = new boolean[row][col];
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<Point> pointList = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        pointList.add(new Point(start[0], start[1]));

        while (!pointList.isEmpty()) {
            Point p = pointList.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < directions.length; i++) {
                int xx = x;
                int yy = y;

                while (xx >= 0 && xx < row && yy >= 0 && yy < col && maze[xx][yy] == 0) {
                    xx += directions[i][0];
                    yy += directions[i][1];
                }

                xx -= directions[i][0];
                yy -= directions[i][1];

                if (visited[xx][yy]) {
                    continue;
                }

                visited[xx][yy] = true;
                if (xx == destination[0] && yy == destination[1]) {
                    return true;
                }

                pointList.offer(new Point(xx, yy));
            }
        }
        return false;
    }
}
