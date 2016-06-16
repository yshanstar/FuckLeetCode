package hack.util;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {
	public int label;
	public List<UndirectedGraphNode> neighbors;

	public UndirectedGraphNode(int v) {
		this.label = v;
		this.neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
