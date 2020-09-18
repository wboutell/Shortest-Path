package BoutellisWalid_Assignment6;


public class Road implements Comparable<Road>{

	private String name;
	private int weight= Integer.MAX_VALUE;
	private Town source;
	private Town destination;
	
	public Road(Town source, Town destination, int weight, String name) {
		this.source= source;
		this.destination= destination;
		this.weight= weight;
		this.name= name;
	}
	
	public Road(Town source, Town destination, String name) {
		this.source= source;
		this.destination= destination;
		this.name= name;
		this.weight= 1;
	}
	
	public boolean contains(Town t) {
		if(this.getSource().getName().compareTo(t.getName()) == 0) {
			return true;
		}
		else if(this.getDestination().getName().compareTo(t.getName()) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return "Road: " + this.getName() + " Source: " + this.getSource().getName() + " Destination: " 
				+ this.getDestination().getName() + " Distance: " + this.getWeight();
	}
	
	public String getName() {
		return this.name;
	}
	
	public Town getDestination() {
		return this.destination;
	}
	
	public Town getSource() {
		return this.source;
	}
	
	@Override
	public int compareTo(Road o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(this == null) {
			return false;
		}
		if(this.getClass() != o.getClass()) {
			return false;
		}
		
		Road r= (Road) o;
		return ( this.getDestination().equals(r.getDestination()) && this.getSource().equals(r.getSource()) ) ||
				( this.getDestination().equals(r.getSource()) && this.getSource().equals(r.getDestination()) );
	}

}
