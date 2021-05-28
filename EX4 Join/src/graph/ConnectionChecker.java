package graph;

import java.util.HashSet;
import java.util.Set;

/*
*	This class get a graph reference and check 
*	with given objects if they are connected or not
*/
public class ConnectionChecker<V> {
	private GraphInterface<V> graph;
	private boolean isConnected = false;
	private Set<V> runDFS;

	public ConnectionChecker(GraphInterface<V> g) {
		graph = g;
	}
	
	/*  Checking if given 2 objects are reachable
	*	from one to another
	*/
	public boolean check(V v1, V v2) {
		if (v1.equals(v2) || v2.equals(v1))
			return true;
		if (graph.neighbours(v1).isEmpty())
			return false;
		runDFS = new HashSet<>();
		DFS(v1, v2);
		return isConnected;
	}

	private void DFS(V start, V end) {
		for (V v : graph.neighbours(start)) {
			if (v.equals(end)) {
				isConnected = true;
				return;
			} else if (!runDFS.contains(v)) {
				runDFS.add(v);
				DFS(v, end);
			}
		}
		return;
	}
}
