package Leetcode;

import java.util.HashMap;

import Leetcode.customerDataType.UndirectedGraphNode;

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		HashMap<UndirectedGraphNode, UndirectedGraphNode> cloned = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		return clone(node, cloned);
	}

	public UndirectedGraphNode clone(UndirectedGraphNode node,
			HashMap<UndirectedGraphNode, UndirectedGraphNode> cloned) {
		if (node == null)
			return null;

		if (cloned.containsKey(node))
			return cloned.get(node);

		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		cloned.put(node, clone);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			clone.neighbors.add(clone(neighbor, cloned));
		}

		return clone;
	}

}
