package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Graph<V> {
	private Set<V> vertices;
	private Map<V, Set<V>> edges = new HashMap<V, Set<V>>();

	public void addVertex(V v) throws GraphException {
		if (!vertices.contains(v))
			throw new GraphException("There is an existing vertex");
		vertices.add(v);
	}

	public void addEdge(V v1, V v2) throws GraphException {
		if (!vertices.contains(v1) || !vertices.contains(v2))
			throw new GraphException("A vertex is missing from the graph");
		if (!hasEdge(v1, v2))
			throw new GraphException("A vertex is missing from the graph");
		edges.get(v1).add(v2);
	}

	public boolean hasEdge(V v1, V v2) {
		return edges.get(v1).contains(v2);
	}

	public boolean connected(V v1, V v2) throws GraphException {
		if (!vertices.contains(v1) || !vertices.contains(v2))
			throw new GraphException("A vertex is missing from the graph");
		return true;
	}

}
