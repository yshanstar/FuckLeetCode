package hack.facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation:
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.
Example 2:
Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
Output: false
Explanation:
The graph looks like this:
0----1
| \  |
|  \ |
3----2
We cannot find a way to divide the set of nodes into two independent subsets.


Note:

graph will have length in range [1, 100].
graph[i] will contain integers in range [0, graph.length - 1].
graph[i] will not contain i or duplicate values.
The graph is undirected: if any element j is in graph[i], then i will be in graph[j].


Reference:
https://leetcode.com/problems/is-graph-bipartite/discuss/115487/Java-Clean-DFS-solution-with-Explanation

 */
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }

        colors[node] = color;
        for (int neighbor : graph[node]) {
            if (!validColor(graph, colors, -color, neighbor)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite2(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return false;
        }

        Set<Integer> setOne = new HashSet<>();
        Set<Integer> setTwo = new HashSet<>();
        Map<Integer, Boolean> unVisistedNodes = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            unVisistedNodes.put(i, false);
        }

        for (int i : unVisistedNodes.keySet()) {
            int[] nodes = graph[i];
            if (!setOne.contains(i) && !setTwo.contains(i)) {
                Set<Integer> set = findSet(setOne, setTwo, nodes);
                if (set == null) {
                    set = setOne;
                }
                set.add(i);
                for (int node : nodes) {
                    if (set == setOne) {
                        setTwo.add(node);
                    } else {
                        setOne.add(node);
                    }
                }
            } else if (setTwo.contains(i)) {
                for (int node : nodes) {
                    setOne.add(node);
                }
            } else {
                for (int node : nodes) {
                    setTwo.add(node);
                }
            }
        }

        return setOne.size() + setTwo.size() == graph.length;
    }

    private Set<Integer> findSet(Set<Integer> setOne, Set<Integer> setTwo, int[] nodes) {
        for (int node : nodes) {
            if (setOne.contains(node)) {
                return setTwo;
            }

            if (setTwo.contains(node)) {
                return setOne;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        IsGraphBipartite test = new IsGraphBipartite();
        int[][] graph = {
                {3},
                {2, 4},
                {1},
                {0, 4},
                {1, 3}
        };
        test.isBipartite2(graph);
    }

    /*

    0 --- 1
          |
 4        |
          |
          2



     */
}
