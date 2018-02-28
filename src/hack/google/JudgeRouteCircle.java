package hack.google;

/*
Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false
 */
public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        if (moves == null || moves.length() == 0) {
            return false;
        }

        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'R':
                    x++;
                    break;
                case 'L':
                    x--;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                default:
                    return false;
            }
        }
        return isBack(x, y);
    }

    private boolean isBack(int x, int y) {
        return x == 0 && y == 0;
    }
}
