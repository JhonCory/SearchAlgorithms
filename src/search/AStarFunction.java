package search;

// Represents heuristic function h(n) in A* or Greedy Best-First Search
public class AStarFunction implements NodeFunction {
	public NodeFunction heuristicFunction;

	public AStarFunction(NodeFunction heuristicFunction) {
		this.heuristicFunction = heuristicFunction;
	}

	public int getValue(Node n) {
		return (n.costToNode + heuristicFunction.getValue(n));
	}

}
