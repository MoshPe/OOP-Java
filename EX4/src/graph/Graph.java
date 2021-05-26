package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V> {
	private Set<V> vertices = new HashSet<>();
	private Map<V, Set<V>> edges = new HashMap<V, Set<V>>();
	private Set<V> runDFS;

	public void addVertex(V v) throws GraphException {
		if (vertices.contains(v))
			throw new GraphException("There is an existing vertex");
		vertices.add(v);
	}

	public void addEdge(V v1, V v2) throws GraphException {
		Set<V> temp;
		if (!vertices.contains(v1) || !vertices.contains(v2))
			throw new GraphException("A vertex is missing from the graph");
		if (hasEdge(v1, v2) || hasEdge(v2, v1))
			throw new GraphException("The edge is already exist in the graph");
		if(edges.get(v1) == null) {
			temp = new HashSet<>();
			temp.add(v2);
			edges.put(v1,temp);
			temp = new HashSet<>();
			temp.add(v1);
			edges.put(v2,temp);
		}
		else {
			edges.get(v1).add(v2);
			if(edges.get(v2) == null) {
				temp = new HashSet<>();
				temp.add(v1);
				edges.put(v2,temp);		
			}
			else
				edges.get(v2).add(v1);
		}
	}

	public boolean hasEdge(V v1, V v2) {
		if(edges.get(v1) == null)
			return false;
		return edges.get(v1).contains(v2);
	}

	public boolean connected(V v1, V v2) throws GraphException {
		if (!vertices.contains(v1) || !vertices.contains(v2))
			throw new GraphException("A vertex is missing from the graph");
		if(hasEdge(v1,v2))
			return true;
		runDFS = new HashSet<>();
		small_DFS(v1, v2);
		return runDFS.contains(v2);
	}
	
	private void small_DFS(V start, V end){
		if(edges.get(start) == null)
			return;
		for (V v : edges.get(start)) {
			if(v.equals(end)) {
				runDFS.add(v);
				return;
			}
			if(!runDFS.contains(v)) {
				runDFS.add(v);
				small_DFS(v,end);
			}
		}
		return;
	}
}
