package hack.Microsoft;

/*
Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
You receive a valid board, made of only battleships or empty slots.
Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
Example:
X..X
...X
...X
In the above board there are 2 battleships.
Invalid Example:
...X
XXXX
...X
This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
Follow up:
Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?

Reference: https://leetcode.com/problems/battleships-in-a-board/discuss/90902/Simple-Java-Solution
 */
public class BattleshipsBoard {
    // This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }

        int m = board.length;
        int n = board[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                }
                if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        BattleshipsBoard test = new BattleshipsBoard();
        char[][] board = {
                {
                        '.', '.', '.', 'X',
                },
                {
                        'X', 'X', 'X', 'X',
                },
                {
                        '.', '.', '.', 'X',
                }
        };
        test.countBattleships(board);
    }
}
