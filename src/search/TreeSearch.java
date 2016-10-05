package search;

public class TreeSearch implements Search {
	protected Frontier frontier;
	protected int nodesGenerated;	
	
	public TreeSearch(Frontier frontier) {
		this.frontier = frontier;
		nodesGenerated = 0;		
	}

	public Node findSolution(Node root, GoalTest goalTest) {
		// Clear data from previous search
		nodesGenerated = 0;
		frontier.clear();

		frontier.addNode(root);
		nodesGenerated += 1;

		Boolean solutionFound = false;
		Node currentNode = null;

		// Expand from root until you find a goal node or run out of nodes
		while (!solutionFound && !frontier.isEmpty()) {
			currentNode = frontier.getNode(); // Remove a node from the frontier
			if (goalTest.isGoal(currentNode.state)) {
				// Check whether the node is at a goal state
				solutionFound = true;
			} else {
				// Expand upon the node
				for (Action action : currentNode.state.getApplicableActions()) {
					nodesGenerated += 1;

					State newState = currentNode.state.getActionResult(action);
					frontier.addNode(new Node(currentNode, action, newState));
				}
			}
		}

		// Split cases based on whether a goal node was found
		if (!solutionFound) {
			return null;
		} else {
			return currentNode;
		}	
	}

	public Integer getLastNumberOfNodes() {
		return nodesGenerated;
	}

}
