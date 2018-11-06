package hack.facebook;

/*
Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.



Example:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]

Explanation:

 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        if (matrix.length == 1) {
            return matrix[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[] ans = new int[m * n];
        int[][] direction = new int[][]{{-1, 1}, {1, -1}};

        int row = 0;
        int col = 0;
        int d = 0;

        for (int i = 0; i < ans.length; i++) {
            ans[i] = matrix[row][col];

            row += direction[d][0];
            col += direction[d][1];

            if (row == m) {
                row = m - 1;
                col += 2;
                d = 1 - d;
            }

            if (col == n) {
                row += 2;
                col = n - 1;
                d = 1 - d;
            }

            if (row < 0) {
                row = 0;
                d = 1 - d;
            }

            if (col < 0) {
                col = 0;
                d = 1 - d;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        DiagonalTraverse test = new DiagonalTraverse();
        int[][] matrix = new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        test.findDiagonalOrder(matrix);
    }
}
