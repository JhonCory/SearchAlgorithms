package search;

public interface Frontier {

	public void addNode(Node n);

	public void clear();

	public Boolean isEmpty();

	public Node getNode();

	public Integer getMaxNodesStored();
}
