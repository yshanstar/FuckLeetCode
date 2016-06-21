package hack.facebook;

import hack.util.Point;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 Answer: 3
 */
public class NumberOfIslands {
	private int[][] direction = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public int numIslandsUnionFind(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		UnionFind uf = new UnionFind(grid);
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					for (int[] dir : direction) {
						int ii = i + dir[0];
						int jj = j + dir[1];
						if (ii < 0 || ii >= m || jj < 0 || jj >= n || grid[ii][jj] != '1') {
							continue;
						} else {
							int idx1 = i * n + j;
							int idx2 = ii * n + jj;
							uf.union(idx1, idx2);
						}
					}
				}
			}
		}

		return uf.count;
	}

	class UnionFind {
		int m;
		int n;
		int[] father;
		int count;

		public UnionFind(char[][] grid) {
			this.m = grid.length;
			this.n = grid[0].length;
			this.count = 0;

			this.father = new int[m * n];

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == '1') {
						this.count++;
						int idx = i * n + j;
						this.father[idx] = -1;
					}
				}
			}
		}

		public void union(int node1, int node2) {
			int x = find(node1);
			int y = find(node2);

			if (x != y) {
				this.count--;
				this.father[x] = y;
			}
		}

		public int find(int node) {
			if (this.father[node] == -1) {
				return node;
			}

			this.father[node] = find(father[node]);
			return this.father[node];
		}
	}

	public int numIslandsBFS(char[][] grid) {
		int res = 0;
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return res;
		}

		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					grid[i][j] = '-';
					res++;

					Queue<Point> queue = new LinkedList<Point>();
					queue.offer(new Point(i, j));
					while (!queue.isEmpty()) {
						Point cur = queue.poll();
						for (int[] dir : direction) {
							int ii = cur.x + dir[0];
							int jj = cur.y + dir[1];

							if (ii < 0 || ii >= m || jj < 0 || jj >= n || grid[ii][jj] != '1') {
								continue;
							} else {
								grid[ii][jj] = '-';
								queue.offer(new Point(ii, jj));
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '-') {
					grid[i][j] = '1';
				}
			}
		}

		return res;
	}
}
