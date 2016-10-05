package mars;

import java.util.HashSet;

import search.BestFirstFrontier;
import search.TreeSearch;
import search.GraphSearch;
import search.GoalTest;
import search.Node;
import search.NodeFunction;
import search.AStarFunction;
import search.Frontier;

/** Finds the best for a Mars rover to explore as many different empty squares
  * on a prespecified map as possible given enough battery for only 20 moves using 
  * A Star Tree Search. */
public class BestPathFinder {
	private static final int[][] layout = new int[][] {
        	{1,1,1,1,0,1,1,1},
        	{1,1,0,0,0,0,0,1},
        	{1,0,1,0,1,0,1,1},
        	{0,0,1,1,1,0,0,0},
        	{1,0,0,1,0,1,0,1},
        	{1,1,0,0,0,1,0,1},
        	{1,1,1,0,0,0,0,1},
        	{1,1,1,1,0,1,1,1},
     	};


	public static void main(String[] args) {

		System.out.println("This is a demonstration of A Star Tree Search on the Mars rover problem.");
		System.out.println();

		HashSet<Tuple<Integer,Integer>> initSpotsExplored = new HashSet<Tuple<Integer,Integer>>();
		initSpotsExplored.add(new Tuple<Integer,Integer>(4,4));
		MiniMap initialConfiguration = new MiniMap(new Planet(layout),4,4,initSpotsExplored,0); 

		Node rootNode = new Node(null,null,initialConfiguration,0);
		GoalTest goalTest = new BatteryTest();
		NodeFunction function = new ExplorationHeuristicFunction();


		// Two frontiers
		Frontier f = new BestFirstFrontier(function);

		// Two searches
		TreeSearch aStarTreeSearch = new TreeSearch(f);

		Node solution = aStarTreeSearch.findSolution(rootNode, goalTest);


		MarsPrinting printer = new MarsPrinting();

		System.out.println("SOLUTION: ");
		printer.printSolution(solution);
		System.out.println();
		
		System.out.println("The search generated "+aStarTreeSearch.getLastNumberOfNodes()+" nodes, and required");
		System.out.println(+f.getMaxNodesStored()+" nodes to be stored on the frontier at any given time.");
		
	}

}