package BoutellisWalid_Assignment6;

import java.util.ArrayList;
import java.util.Collections;

public class TownGraphManager implements TownGraphManagerInterface{

	private TownGraph tGraph;
	private ArrayList<Town> towns;
	private ArrayList<Road> roads;
	
	public TownGraphManager() {
		tGraph= new TownGraph();
		towns= new ArrayList<Town>();
		roads= new ArrayList<Road>();
	}
	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town t1= new Town(town1);
		Town t2= new Town(town2);
		Road r= new Road(t1, t2, weight, roadName);
		roads.add(r);
		
		tGraph.addEdge(t1, t2, weight, roadName);
		return true;
	}
	
	public void addRoad(String town1, String town2, String roadName) {
		String [] values= roadName.split(",");
		int distance= Integer.parseInt(values[1]);
		String name= values[0];
		addRoad(town1, town2, distance, name);
	}

	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	@Override
	public String getRoad(String town1, String town2) {
		String str= "";
		for(Road r: roads) {
			if( (r.getSource().getName().equals(town1) && r.getDestination().getName().equals(town2)) ||
					(r.getSource().getName().equals(town2) && r.getDestination().getName().equals(town1))) {
				str+= r.getName();
			}
			else {
				str= null;
			}
		}
		return str;
	}

	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */	
	@Override
	public boolean addTown(String v) {
		boolean flag= false;
		Town temp= new Town(v);
		tGraph.addVertex(temp);
		towns.add(temp);
		flag= true;
		return flag;
	}

	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	@Override
	public Town getTown(String name) {
		Town t= new Town(name);
		if(towns.contains(t)) {
			return t;
		}
		else {
			return null;
		}
	}

	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	@Override
	public boolean containsTown(String v) {
		Town t= new Town(v);
		if(tGraph.containsVertex(t)) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		boolean flag= false;
		Town t1= new Town(town1);
		Town t2= new Town(town2);
		for(Road r : roads) {
			if(r.contains(t1) && r.contains(t2)) {
				flag= true;
			}
		}
		return flag;
	}

	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> rNames= new ArrayList<String>();
		for(Road r: roads) {
			rNames.add(r.getName());
		}
		Collections.sort(rNames, String.CASE_INSENSITIVE_ORDER);
		return rNames;
	}

	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	@Override
	public boolean deleteTown(String v) {
		boolean flag= false;
		Town temp= new Town(v);
		for(Town t : tGraph.vertexSet()) {
			if(temp.compareTo(t) == 0) {
				tGraph.removeVertex(temp);
				towns.remove(temp);
				flag= true;
			}
		}
		return flag;
	}
	
	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> tNames= new ArrayList<String>();
		for(Town t: tGraph.vertexSet()) {
			tNames.add(t.getName());
		}
		Collections.sort(tNames, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
		return tNames;
	}

	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		// TODO Auto-generated method stub
		ArrayList<String> temp= new ArrayList<String>();
		Town t1= new Town(town1);
		Town t2= new Town(town2);
		
		temp= tGraph.shortestPath(t1, t2);
		for(String s : temp) {
			System.out.println(s);
		}

		//return tGraph.shortestPath(t1, t2);
		return temp;
	}
	public void clearTownFields() {
		// TODO Auto-generated method stub
		
	}

}
