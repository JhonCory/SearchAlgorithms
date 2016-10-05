package search;

public interface Search {

	public Node findSolution(Node root, GoalTest goalTest);

	public Integer getLastNumberOfNodes();

}
