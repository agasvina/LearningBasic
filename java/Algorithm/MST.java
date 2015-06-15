import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * This is the class implementation of MST using the
 * Kruskal algorithm with a helper class DisjointSet
 * and a simple greedy algorithm 
 * For all vertexes, make a disjoint set
 * Sorted all edges
 * for all elements of edges: 
 * 		if it is a disjoint set add,
 * 		union both edge.from and edge.to
 * 		do nothing otherwise
 * @author luca 
 * @version 1.1
 * */
public class MST {

	public static  ArrayList<Edge> mst(ArrayList<Edge> edges) {
		//make Disjoint set from all the edges
		ArrayList<Character> allVertex = new ArrayList<Character>();
		ArrayList<Edge> allEdgesResult = new ArrayList<Edge>();
		for(int i  = 0; i < edges.size(); i++) {
			allVertex.add(edges.get(i).from);
			allVertex.add(edges.get(i).to);
		}
		
		
		DisjointSet DS = new DisjointSet(allVertex);
		//iteration 
		//sort all the edges to greedily process the minimum edges
		Collections.sort(edges, Edge.EdgeComparator);
		System.out.println(Arrays.toString(edges.toArray()));
		
		for(int i = 0; i < edges.size(); i++) {
			//Finding whether the vertex belong to the same set,
			//if not, we push the the edges to allEdgesResult and union the vertexes
			//otherwise do nothing
			char v1 = edges.get(i).from;
			char v2 = edges.get(i).to;
			if(DS.findParent(v1) != DS.findParent(v2)) {
				allEdgesResult.add(edges.get(i));
				DS.union(v1, v2);
			}
		}
		return allEdgesResult;
		
	}
	
	public static void main(String [] args) {
		//make edges.
		ArrayList<Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge('a', 'b', 1));
		edges.add(new Edge('b', 'c', 5));
		edges.add(new Edge('c','a', 3));
		edges.add(new Edge('a', 'd', 2));
		edges.add(new Edge('d', 'b', 6));
		edges.add(new Edge('c', 'd', 4));
		
		ArrayList<Edge> result = mst(edges);
		System.out.println(Arrays.toString(result.toArray()));
	}
	
	
}

class Edge {
	char from;
	char to; 
	int weight;
	
	public Edge(char f, char t, int w) {
		this.from = f;
		this.to = t;
		this.weight = w;
	}
	
	public static Comparator<Edge> EdgeComparator = new Comparator<Edge>() {

		@Override
		public int compare(Edge o1, Edge o2) {
			//if weight o1 > weight o2, o1 is bigger than o2. Therefore it this 
			//compare() will return 1
			if(o1.weight > o2.weight) return 1;
			if(o2.weight > o1.weight) return -1;
			return 0;
		}
		
		
	};
	
	@Override
	public String toString() {
		return " " +this.from + "--" + this.weight + "-->" + this.to + " "; 
	}
}

class DisjointSet{
	Map<Character, Character> parents;
	Map<Character, Integer> depths;
	
	public DisjointSet(ArrayList<Character> vertex) {
		parents = new HashMap<Character, Character>();
		depths = new HashMap<Character, Integer>();
		for(int i = 0; i < vertex.size(); i++) {
			parents.put(vertex.get(i), vertex.get(i));
			depths.put(vertex.get(i),0);
		}
	}
	
	//assume that the vertex is always found in the map
	public char findParent(char vertex) {
		if(parents.get(vertex) != null && parents.get(vertex) == vertex) {
			return vertex;
		} else {
			//recursively find the parent of parent.
			return findParent(parents.get(vertex));
		}
	}
	
	public void union(char v1, char v2) {
		if(depths.get(v1) > depths.get(v2)) {
			parents.put(v2, v1);
		} else if(depths.get(v1) < depths.get(v2)) {
			parents.put(v1, v2);
		} else {
			parents.put(v1, v2);
			//because parents[v1] = v2, v2 has more child. Therefore, depth[v2]++;
			depths.put(v2, depths.get(v2)+1);
		}
	}
}

