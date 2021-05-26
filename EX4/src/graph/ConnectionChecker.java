package graph;

import java.util.HashSet;
import java.util.Set;

public class ConnectionChecker<V> {
	private GraphInterface<V> graph;
	private boolean isConnected = false;
	private Set<V> runDFS;

	public ConnectionChecker(GraphInterface<V> g) {
		graph = g;
	}

	public boolean check(V v1, V v2) {
		if (v1.equals(v2) || v2.equals(v1))
			return true;
		runDFS = new HashSet<>();
		DFS(v1, v2);
		return isConnected;
	}

	private void DFS(V start, V end) {
		for (V v : graph.neighbours(start)) {
			if (v.equals(end)) {
				isConnected = true;
				return;
			}
			else if(!runDFS.contains(v)){
				runDFS.add(v);
				DFS(v, end);
			}
		}
		return;
	}
}
