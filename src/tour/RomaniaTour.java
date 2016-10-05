package tour;

import search.BreadthFirstTreeSearch;
import search.GoalTest;
import search.Node;

/** Uses Breadth-First Tree Search to determine the shortest path to visit each city 
  * in Romania, given an initial city. */ 
public class RomaniaTour {
	public static void main(String[] args) {
		System.out.println("This is a demonstration of Breadth-First Tree Search on Romania tour.");
		System.out.println();
		
		Cities romania = SetUpRomania.getRomaniaMapSmall();
		City startCity = romania.getState("Bucharest");
		
		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
		Node solution = BreadthFirstTreeSearch.findSolution(new TourState(startCity), goalTest);
		new TourPrinting().printSolution(solution);
	}
}
