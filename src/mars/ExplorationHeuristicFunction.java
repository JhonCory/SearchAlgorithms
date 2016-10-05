package mars;

import search.NodeFunction; 
import search.Node; 

public class ExplorationHeuristicFunction implements NodeFunction {

	/* Returns the difference between the number of different squares explored 	
	/ (not including the starting square) and the number of moves made
	/ Equals the number of moves made to pre-explored states */
	public int getValue(Node n) {
		MiniMap m = (MiniMap) n.state; // downcast the node's state
		return (m.numSpotsExplored() - m.numMovesMade() + 1);
	}

}
