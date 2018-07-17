package hack.Others;

import java.util.Random;

/*
Given a function rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which generates a uniform random integer in the range 1 to 10.

Do NOT use system's Math.random().



Example 1:

Input: 1
Output: [7]
Example 2:

Input: 2
Output: [8,4]
Example 3:

Input: 3
Output: [8,1,10]


Note:

rand7 is predefined.
Each testcase has one argument: n, the number of times that rand10 is called.


Follow up:

What is the expected value for the number of calls to rand7() function?
Could you minimize the number of calls to rand7()?


Reference:
https://leetcode.com/problems/implement-rand10-using-rand7/discuss/150301/Three-line-Java-solution-the-idea-can-be-generalized-to-%22Implement-RandM()-Using-RandN()%22
https://stackoverflow.com/questions/137783/expand-a-random-range-from-1-5-to-1-7


 */
public class ImplementRand10UsingRand7 {
    public int rand10() {
        // Implement randM() using randN() when M > N:
        // N ^ b * (randN() - 1) + N ^ (b - 1) * (randN() - 1) + N ^ (b - 2) * (randN() - 1) + ... + N ^ 0 * (randN() - 1)
        // generates randX() - 1, where X = N ^ (b + 1).
        int result = 40;
        while (result >= 40) {
            result = 7 * (rand7() - 1) + (rand7() - 1);
        }

        return result % 10 + 1;
    }

    public int rand10_method2() {
        // Matrix with 7*7 and fill with 1-10.
        int[][] matrix = {
                {1, 2, 3, 4, 5, 6, 7},
                {8, 9, 10, 1, 2, 3, 4},
                {5, 6, 7, 8, 9, 10, 1},
                {2, 3, 4, 5, 6, 7, 8},
                {9, 10, 1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
        };
        int result = 0;
        while (result == 0) {
            int i = rand7() - 1;
            int j = rand7() - 1;
            result = matrix[i][j];
        }

        return result;
    }

    public int rand7() {
        return new Random().nextInt(7) + 1;
    }

}
