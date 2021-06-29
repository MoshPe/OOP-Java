package Winter2019;

public class Edge {
	private Node to, from;
	
	public Edge(Node from, Node to) {
		this.from = from;
		this.to = to;
	}
	
	public Node getFrom() {
		return from;
	}

	public Node getTo() {
		return to;
	}
}
