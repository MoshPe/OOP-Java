package Winter2019;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Node implements Iterable<Edge>{
	private int id;
	private Edge[] edges = null;
	private int countEdges;

	public Node(int id, Edge[] edges) {
		this.id = id;
		this.edges = edges;
		countEdges = 0;
	}
	
	public Node(int id) {
		this.id = id;
	}
	
	public int getID() { return id; }
	
	public int getNumOfEdges() { return edges.length; }
	
	public void connectEdge(Edge edge) {
		if(edges == null || ) {
			
		}
		edges[countEdges++] = edge;
	}
	
	
	private class EdgeIterable implements Iterator<Edge>{
		int edgeIterateCount = 0;
		
		@Override
		public boolean hasNext() {
			return edgeIterateCount != countEdges;
		}

		@Override
		public Edge next() {
			if(!hasNext())
				throw new NullPointerException();
			return edges[edgeIterateCount++];
		}
	}
	
	@Override
	public String toString() {
		StringBuilder nodeInfo = new StringBuilder();
		nodeInfo.append(id + "[");
		for (Edge edge : edges)
			nodeInfo.append(edge.getTo().getID()+",");
		nodeInfo.append("]");
	return nodeInfo.toString();
	}

	@Override
	public Iterator iterator() {
		return new EdgeIterable();
	}
}
