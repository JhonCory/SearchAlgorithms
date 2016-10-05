package search;

// Represents f(n) or h(n) in A* or Greedy Best-First Search, respectively
public interface NodeFunction {

	public int getValue(Node n);

}
