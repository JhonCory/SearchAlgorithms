package search;

import java.util.Stack;
import java.util.EmptyStackException;

public class DepthFirstFrontier implements Frontier {
	protected Integer maxNodesStored;
	protected Integer currentNodesStored;

	protected Stack<Node> nodes; // implements DPS's first-in-last-out queue


	public DepthFirstFrontier() {
		nodes = new Stack();
		maxNodesStored = 0;
		currentNodesStored = 0;
	}

	public void addNode(Node n) {
		nodes.push(n);

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

	// Removes and returns the most recent node added
	public Node getNode() {
		Node n = null;
		try {
			n = nodes.pop();
			currentNodesStored -= 1;
		} catch (EmptyStackException e) {
			e.printStackTrace();
		}
		return n;	
	}


	public Integer getMaxNodesStored() {
		return maxNodesStored;
	}
}