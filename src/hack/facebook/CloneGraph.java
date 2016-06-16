package hack.facebook;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import hack.util.UndirectedGraphNode;

/*
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
 */
public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}

		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);

		Queue<UndirectedGraphNode> nodeQueue = new LinkedList<UndirectedGraphNode>();
		nodeQueue.offer(node);

		Map<Integer, UndirectedGraphNode> nodeMap = new HashMap<Integer, UndirectedGraphNode>();
		nodeMap.put(copy.label, copy);

		while (!nodeQueue.isEmpty()) {
			UndirectedGraphNode cur = nodeQueue.poll();
			UndirectedGraphNode copyCur = nodeMap.get(cur.label);

			for (UndirectedGraphNode child : cur.neighbors) {
				if (!nodeMap.containsKey(child.label)) {
					UndirectedGraphNode newChild = new UndirectedGraphNode(child.label);
					nodeMap.put(newChild.label, newChild);
					copyCur.neighbors.add(newChild);
					nodeQueue.offer(child);
				} else {
					UndirectedGraphNode copyChild = nodeMap.get(child.label);
					copyCur.neighbors.add(copyChild);
				}
			}
		}

		return copy;
	}
}
