package hack.google;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}

		int row = matrix.length;
		int col = matrix[0].length;
		int x = 0;
		int y = 0;

		while (row > 0 && col > 0) {
			if (row == 1) {
				for (int i = 0; i < col; i++) {
					res.add(matrix[x][y++]);
				}
				break;
			}

			if (col == 1) {
				for (int i = 0; i < row; i++) {
					res.add(matrix[x++][y]);
				}
				break;
			}

			for (int i = 0; i < col - 1; i++) {
				res.add(matrix[x][y++]);
			}

			for (int i = 0; i < row - 1; i++) {
				res.add(matrix[x++][y]);
			}

			for (int i = 0; i < col - 1; i++) {
				res.add(matrix[x][y--]);
			}

			for (int i = 0; i < row - 1; i++) {
				res.add(matrix[x--][y]);
			}

			x++;
			y++;
			row -= 2;
			col -= 2;
		}

		return res;
	}
}
