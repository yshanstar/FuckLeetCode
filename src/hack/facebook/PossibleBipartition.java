package hack.facebook;

import java.util.Arrays;

/*
Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group.

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.



Example 1:

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:

Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false


Note:

1 <= N <= 2000
0 <= dislikes.length <= 10000
1 <= dislikes[i][j] <= N
dislikes[i][0] < dislikes[i][1]
There does not exist i != j for which dislikes[i] == dislikes[j].
 */
public class PossibleBipartition {

    // https://leetcode.com/problems/possible-bipartition/discuss/173898/Java-Union-Find-Solution
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] colors = new int[N + 1];
        for (int i = 1; i <= N; ++i) colors[i] = i;
        for (int[] dislike : dislikes) {
            int p1 = dislike[0], p2 = dislike[1];
            if (colors[p2] == p2) colors[p2] = p1;
            else {
                int[] uf1 = find(p1, colors), uf2 = find(p2, colors);
                if (Arrays.equals(uf1, uf2)) return false;
            }
        }
        return true;
    }

    private int[] find(int p, int[] colors) {
        int color = 0;
        while (colors[p] != p) {
            p = colors[p];
            color = color == 0 ? 1 : 0;
        }
        return new int[]{p, color};
    }

    public static void main(String[] args) {
        PossibleBipartition test = new PossibleBipartition();
        int[][] dislikes = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        test.possibleBipartition(5, dislikes);
    }

    // https://leetcode.com/problems/possible-bipartition/discuss/158957/Java-DFS-solution
    public boolean possibleBipartitionDFS(int N, int[][] dislikes) {
        int[][] graph = new int[N][N];

        for (int[] dislike : dislikes) {
            int first = dislike[0];
            int second = dislike[1];
            graph[first - 1][second - 1] = 1;
            graph[second - 1][first - 1] = 1;
        }

        int[] group = new int[N];

        for (int i = 0; i < N; i++) {
            if (group[i] == 0 && !dfs(graph, group, i, 1)) {
                return false;
            }
        }

        return true;
    }

    // group[i] == 0 -- not visited
    // group[i] == 1 -- in group 1
    // group[i] == -1 -- in group -1
    private boolean dfs(int[][] graph, int[] group, int idx, int value) {
        group[idx] = value;
        for (int i = 0; i < graph.length; i++) {
            if (graph[idx][i] == 1) {
                // Cannot group them together
                if (group[i] == value) {
                    return false;
                }

                if (group[i] == 0 && !dfs(graph, group, i, -value)) {
                    return false;
                }
            }
        }
        return true;
    }
}
