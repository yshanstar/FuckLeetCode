package hack.Others;

/*
Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

Example 1:

Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
Example 2:

Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Notes:

1 <= A.length = A[0].length <= 20
0 <= A[i][j] <= 1

 */
public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        reverseMatrix(A);
        invertMatrix(A);
        return A;
    }

    private void reverseMatrix(int[][] A) {
        for (int row = 0; row < A.length; row++) {
            int start = 0;
            int end = A[row].length - 1;
            while (start < end) {
                int tmp = A[row][start];
                A[row][start] = A[row][end];
                A[row][end] = tmp;
                start++;
                end--;
            }
        }
    }

    private void invertMatrix(int[][] A) {
        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < A[row].length; col++) {
                A[row][col] = Math.abs(A[row][col] - 1);
            }
        }
    }
}
