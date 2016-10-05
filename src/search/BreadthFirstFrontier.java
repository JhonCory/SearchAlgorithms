package search;

import java.util.LinkedList;

public class BreadthFirstFrontier implements Frontier {
	protected Integer maxNodesStored;
	protected Integer currentNodesStored;
	protected LinkedList<Node> nodes;

	public BreadthFirstFrontier() {
		nodes = new LinkedList();
		maxNodesStored = 0;
		currentNodesStored = 0;
	}

	public void addNode(Node n) {
		nodes.add(n);

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

	// Removes and returns the oldest node 
	public Node getNode() {
		Node node = null;
		try {
			if (isEmpty()) {
				throw new IllegalArgumentException("Empty Queue");
			} else {
				currentNodesStored -= 1;
				node = nodes.remove();
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return node;
	}

	public Integer getMaxNodesStored() {
		return maxNodesStored;
	}
}