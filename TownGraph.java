package BoutellisWalid_Assignment6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TownGraph implements GraphInterface<Town, Road>{

	private HashSet<Town> towns;
	private HashSet<Road> roads;
	
	
	public TownGraph() {
		towns= new HashSet<Town>();
		roads= new HashSet<Road>();
		
	}
    /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		Road temp= null;
		if(sourceVertex == null || destinationVertex == null) {
			return temp;
		}
		else {
			for(Road r: roads) {
				if(r.getSource().compareTo(sourceVertex)== 0 && r.getDestination().compareTo(destinationVertex)== 0 || 
						(r.getSource().compareTo(destinationVertex)== 0 && r.getDestination().compareTo(sourceVertex) == 0)) {
					temp= r;
				}
			}
			return temp;
		}
	}

    /**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. 
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     * @throws NullPointerException if any of the specified vertices is null.
     */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if(sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();
		}
		//Add the road to the set of roads
		Road r= new Road(sourceVertex, destinationVertex, weight, description);
		roads.add(r);
		sourceVertex.addAdjTown(destinationVertex, weight);
		destinationVertex.addAdjTown(sourceVertex, weight);
		return r;

	}

    /**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     */
	@Override
	public boolean addVertex(Town v) {
		if(towns.contains(v)) {
			return false;
		}
		else {
			towns.add(v);
			return true;
		}
	}

	  /**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for(Road r: roads) {
			if ((r.contains(sourceVertex) && r.contains(destinationVertex)) && (sourceVertex != null && destinationVertex != null)) {
				return true;
			}
		}
		return false;
	}

    /**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
	@Override
	public boolean containsVertex(Town v) {
		for(Town t: towns) {
			if(t.getName().compareTo(v.getName()) == 0) {
				return true;
			}
		}
		return false;
	}

    /**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     *
     * @return a set of the edges contained in this graph.
     */
	@Override
	public Set<Road> edgeSet() {
		return roads;
	}

    /**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws NullPointerException if vertex is null.
     */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> temp= new HashSet<Road>();
		if(vertex == null) {
			throw new NullPointerException();
		}
		for(Road r: roads) {
			if(r.contains(vertex)) {
				temp.add(r);
			}
		}
		return temp;
	}

	/**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road temp= new Road(sourceVertex, destinationVertex, weight, description);
		roads.remove(temp);
		return temp;
	}

	/**
     * Removes the specified vertex from this graph.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
	@Override
	public boolean removeVertex(Town v) {
		return towns.remove(v);
	}
	

	 /**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */
	@Override
	public Set<Town> vertexSet(){
		return towns;
	}

	 /**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     * They will be in the format: startVertex "via" Edge "to" endVertex weight
	 * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
	 * would be in the following format(this is a hypothetical solution):
	 * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
	 * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
	 * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
     */ 
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		dijkstraShortestPath(sourceVertex);
	      
	    ArrayList<String> sp = new ArrayList<String>();
	    LinkedList<Town> allTowns = destinationVertex.getShortestPath();
	      
	    for(int i = 0; i < allTowns.size(); i++){
	        sp.add(allTowns.get(i).toString());  
	        
	       // System.out.println(allTowns.get(i).toString());	//For debugging
	    }
	    sp.add(destinationVertex.toString());
	    
	    //System.out.println(destinationVertex.toString());	//For debugging
	    return sp;
	}

	/**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
     * 
     */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		sourceVertex.setWeight(0);
		Set<Town> s1= new HashSet<>();
		Set<Town> s2= new HashSet<>();
		s2.add(sourceVertex);
		
		while(s2.size() > 0) {
			Town temp= getClosestTown(s2);
			s2.remove(temp);
			
			for(Map.Entry<Town, Integer> e: temp.getAdjacentTowns().entrySet()) {
				Town adjTown= e.getKey();
				Integer roadDist= e.getValue();
				
				if(!s1.contains(adjTown)) {
					shortestDistance(adjTown, roadDist, temp);
					s2.add(adjTown);
				}
			}
			s1.add(temp);
		}
	}
	
	//Helper method to implement Dijkstra's shortest path
	//This method finds the closest town in a set of towns (parameter)
	private static Town getClosestTown(Set<Town> myTowns) {
		Town closeTown= null;
		int threshold= Integer.MAX_VALUE;
		for(Town t: myTowns) {
			int distance= t.getWeight();
			if(distance < threshold) {
				threshold= distance;
				closeTown= t;
			}
		}
		return closeTown;
	}
	
	//Helper method to implement Dijkstra's shortest path
	private static void shortestDistance(Town evalVertex, Integer dist, Town sourceTown) {
		Integer sourceDist= sourceTown.getWeight();
		if(sourceDist + dist < evalVertex.getWeight()) {
			evalVertex.setWeight(sourceDist + dist);
			LinkedList<Town> sp= new LinkedList<>(sourceTown.getShortestPath());
			sp.add(sourceTown);
			evalVertex.setShortestPath(sp);
		}
	}
	
	

}
