package BoutellisWalid_Assignment6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class Town implements Comparable<Town>{
	
	private String name;
	private Map<Town, Integer> adjacentTowns;
	private LinkedList<Town> sPath;
	private int weight;
	
	/**
	 * Parameterized Constructor
	 * @param name- the name of the Town object*/
	public Town(String name) {
		this.name= name;
		this.adjacentTowns= new HashMap<Town, Integer>();
		this.sPath= new LinkedList<Town>();
		this.weight= Integer.MAX_VALUE;
	}
	
	/**
	 * Copy constructor
	 * @param templateTown- an instance of Town
	 * */
	public Town (Town templateTown) {
		this.name= templateTown.name;
		this.adjacentTowns= templateTown.adjacentTowns;
		this.sPath= new LinkedList<Town>();
		this.weight= templateTown.weight;
	}
	
	/*public Town(String name, Map<Town, Integer>()) {
		this.name= name;
		this.adjacentTowns= AdjTowns;
		this.sPath= new LinkedList<Town>();
		this.weight= Integer.MAX_VALUE;
	
	}*/
	
	/**
	 * Getter for town name
	 * @return the town's name
	 * */
	public String getName() {
		return this.name;
	}
	
	public void setWeight(int w) {
		this.weight= w;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public void addAdjTown(Town destinationVertex, int weight){
		this.adjacentTowns.put(destinationVertex, weight);
	}
	
	public LinkedList<Town> getShortestPath(){
		return sPath;
	}
	
	public void setShortestPath(LinkedList<Town> sPath){
       this.sPath = sPath;
    }
	
	public Map<Town, Integer> getAdjacentTowns(){
		return adjacentTowns;
	}

	@Override
	public int compareTo(Town o) {
		if(this.name.compareToIgnoreCase(o.name) < 0) {
			return -1;
		}
		else if(this.name.compareToIgnoreCase(o.name) > 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public String toString() {
		return "Town{ " + "Name: " + this.getName()+ " " + "AdjacentTowns: " + adjacentTowns.values() + " }";
	}
	
	public int hashCode() {
		return this.getName().hashCode();
	}
	
	public boolean equals(Object o) {
		//Self check
		if(this == o) {
			return true;
		}
		//Type check
		if(this.getClass() != o.getClass()) {
			return false;
		}
		//Field check
		Town t= (Town) o;
		return this.getName().equals(t.getName());
	}

}
