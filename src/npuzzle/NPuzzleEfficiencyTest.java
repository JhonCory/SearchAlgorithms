package npuzzle;



import search.BestFirstFrontier;
import search.TreeSearch;
import search.GraphSearch;
import search.GoalTest;
import search.Node;
import search.NodeFunction;
import search.AStarFunction;
import search.Frontier;


/** Determines the optimal solution for solving a specified tile puzzle using A Star
  * Search as a test to compare the relative effectiveness of A Star Tree Search and 
  * A Star Graph Search. */ 
public class NPuzzleEfficiencyTest {

	public static void main(String[] args) {

		System.out.println("This is an efficiency comparison between A Star Tree and Graph Searches being used to solve an 8-puzzle.");
		System.out.println();

		Tiles initialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});

		Node rootNode = new Node(null,null,initialConfiguration,0);
		GoalTest goalTest = new TilesGoalTest();


		// One NodeFunction
		AStarFunction function = new AStarFunction(new MisplacedTilesHeuristicFunction());

		// Two frontiers
		Frontier f1 = new BestFirstFrontier(function);
		Frontier f2 = new BestFirstFrontier(function);

		// Two searches
		TreeSearch aStarTreeSearch = new TreeSearch(f1);
		GraphSearch aStarGraphSearch = new GraphSearch(f2);

		// Two solutions
		Node solution2 = aStarGraphSearch.findSolution(rootNode, goalTest);
		Node solution1 = aStarTreeSearch.findSolution(rootNode, goalTest);

		System.out.println("A Star Tree Search: ");
		new NPuzzlePrinting().printSolution(solution1);
		System.out.println("");

		System.out.println("A Star Graph Search: ");
		new NPuzzlePrinting().printSolution(solution2);
		System.out.println("");

		
		System.out.println("A Star Tree Search generated "+aStarTreeSearch.getLastNumberOfNodes()+" nodes, and required");
		System.out.println(+f1.getMaxNodesStored()+" nodes to be stored on the frontier at any given time.");
		System.out.println("");
		System.out.println("A Star Graph Search generated "+aStarGraphSearch.getLastNumberOfNodes()+" nodes, and required");
		System.out.println(+f2.getMaxNodesStored()+" nodes to be stored on the frontier at any given time.");
		
	}

}