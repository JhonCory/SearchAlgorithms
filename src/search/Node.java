package search;



public class Node {
	
	public final Node parent;
	
	public final Action action;
	
	public final State state;
	
	public int value;

	public final int costToNode;
	
	public Node(Node parent, Action action, State state) {
		
		this.parent = parent;
		
		this.action = action;
		
		this.state = state;

		this.costToNode = parent.value + action.cost();
	
	}

	public Node(Node parent, Action action, State state, int costToNode) {
		
		this.parent = parent;
		
		this.action = action;
		
		this.state = state;

		this.costToNode = costToNode;
	
	}

}
