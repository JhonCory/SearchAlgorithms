package search;

import java.util.ArrayList;

public class BestFirstFrontier implements Frontier {
	protected Integer maxNodesStored;
	protected Integer currentNodesStored;

	protected ArrayList<Node> nodes;
	protected NodeFunction nodeFunction;

	public BestFirstFrontier(NodeFunction nodeFunction) {
		nodes = new ArrayList();
		maxNodesStored = 0;
		currentNodesStored = 0;
		this.nodeFunction = nodeFunction;
	}

	public void addNode(Node newNode) {
		int newValue = nodeFunction.getValue(newNode);
		newNode.value = newValue; // Calculate the value of the node using the NodeFunction, then set it in the node

		int i = 0;
		while (i<nodes.size() && nodeFunction.getValue(nodes.get(i)) > newValue) {
			i++;
		}
		nodes.add(i,newNode);

		currentNodesStored += 1;
		if (currentNodesStored > maxNodesStored) {
			maxNodesStored = currentNodesStored;
		}
	}

	public void clear() {
		nodes.clear();
		currentNodesStored = 0;
	}

	public Boolean isEmpty() {
		return currentNodesStored == 0;
	}

	// Removes and returns the node with best (i.e. smallest) value according to the heuristic, h
	public Node getNode() {
		Node n = null;
		try {
			if (isEmpty()) {
				throw new IllegalArgumentException("No Nodes");
			} else {
				currentNodesStored -= 1;
				n = nodes.remove(0);
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return n;
	}

	public Integer getMaxNodesStored() {
		return maxNodesStored;
	}
}
