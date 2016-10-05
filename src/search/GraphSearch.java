package search;

import java.util.Hashtable;

public class GraphSearch implements Search {
	protected Frontier frontier;
	protected Integer nodesGenerated;	

	public GraphSearch(Frontier frontier) {
		this.frontier = frontier;
		nodesGenerated = 0;
	}

	public Node findSolution(Node root, GoalTest goalTest) {
		// Clear data from previous search
		nodesGenerated = 0;
		frontier.clear();

		frontier.addNode(root);
		nodesGenerated +=1;
		Hashtable<Integer,State> stateTable = new Hashtable<Integer,State>(); // contains the states already visited
		
		Node currentNode = null;
		Boolean solutionFound = false;

		// Expand from root until you find a goal node or run out of nodes
		while (!solutionFound && !frontier.isEmpty()) {
			currentNode = frontier.getNode();

			if (goalTest.isGoal(currentNode.state)) {
				// Check whether the node is at a goal state
				solutionFound = true;
			} else {
				// Expand upon the node; discard a node if it's of a state we've already seen
				for (Action action : currentNode.state.getApplicableActions()) {
					nodesGenerated += 1; 
					State newState = currentNode.state.getActionResult(action);

					if (!stateTable.containsKey(currentNode.state.hashCode())) {

						stateTable.put(Integer.valueOf(newState.hashCode()), newState);
						frontier.addNode(new Node(currentNode, action, newState));
					}
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
