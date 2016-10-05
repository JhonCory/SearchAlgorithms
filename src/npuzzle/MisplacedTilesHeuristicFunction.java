package npuzzle;

import search.NodeFunction; 
import search.Node; 

public class MisplacedTilesHeuristicFunction implements NodeFunction {

	// Returns the number of tiles not in their proper places
	public int getValue(Node n) {
		Tiles t = (Tiles) n.state; // downcast the Node into a Tiles

		int numWrongTiles = 0;
		
		for (int i=0; i<t.getWidth(); i++) {
			for (int j=0; j<t.getWidth(); j++) {
				if (t.getTile(i,j) != 1+i*(t.getWidth())+j) {
					numWrongTiles += 1;
				}
			}
		}
		return numWrongTiles;
	}

}
