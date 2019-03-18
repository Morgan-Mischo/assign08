package lab08;

import java.util.LinkedList;
import java.util.Iterator;

/**
 * This class represents a vertex (AKA node) in a directed graph. The vertex is
 * not generic, assumes that a string name is stored there.
 * 
 * @author Erin Parker
 * @version March 1, 2019
 */
public class Vertex {

	// used to id the Vertex
	private String name;

	// adjacency list
	private LinkedList<Edge> adj;
	
	//vertex
	private Vertex prev; 
	
	//distance
	private double dist; 
	
	private boolean visited; 
	

	public Vertex(String name) {
		this.name = name;
		this.adj = new LinkedList<Edge>();
	}

	public String getName() {
		return name;
	}
	
	public void addEdge(Vertex otherVertex) {
		adj.add(new Edge(otherVertex));
	}

	public void addEdge(Vertex v, double weight) {
		adj.add(new Edge(v, weight)); 
	}

	public Iterator<Edge> edges() {
		return adj.iterator();
	}

	public String toString() {
		String s = "Vertex " + name + " adjacent to ";
		Iterator<Edge> itr = adj.iterator();
		while(itr.hasNext())
			s += itr.next() + "  ";
		return s;
	}

	public Vertex getPrevious() {
		return prev;
	}

	public void setPrevious(Vertex prev) {
		this.prev = prev;
	}

	public double getDistanceFromStart() {
		return dist;
	}

	public void setDistanceFromStart(double dist) {
		this.dist = dist;
	}

	public boolean getVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public LinkedList<Edge> getEdges(){
		return adj; 
	}
	public int compareTo(Vertex o) {
		return Double.compare(this.dist, o.dist); 
	}
}