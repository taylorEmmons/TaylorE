package program3;

import java.awt.Point;

public class Car {

	private Point location;
	private String ID;
	private Point destination;

	public Car(Point location, String ID) {
		this.location = new Point((int)location.getX(),(int)location.getY());
		this.ID = ID;
	}
	
	public void setDestination(Point dest) {
		this.destination = dest;
	}
	
	public void setLocation(Point loca) {
		this.location = loca;
	}
	
	public void translate(Point dVal) {
		this.location.x += dVal.getX();
		this.location.y += dVal.getY();
	}
	
	public Direction nextMove() {
		
		Point distance; 
			if(this.getLocation().getX() != this.getDestination().getX()) {
				distance = new Point((int) (this.getDestination().getX() - this.getLocation().getX()),
						(int) (this.getDestination().getY() - this.getLocation().getY()));	
	
				switch((int) distance.getX()/Math.abs((int) distance.getX())) {
					case 1:
						this.translate(new Point(1,0));
						return Direction.EAST;
					case -1:
						
						this.translate(new Point(-1,0));
						return Direction.WEST;
				}	
			}
			
			if(this.getLocation().getY() != this.getDestination().getY()) {	
				distance = new Point((int) (this.getDestination().getX() - this.getLocation().getX()),
								(int) (this.getDestination().getY() - this.getLocation().getY()));	
					
				switch((int) distance.getY()/Math.abs((int) distance.getY())) {
					case 1:
						this.translate(new Point(0,1));
						return Direction.NORTH;
					case -1:
						this.translate(new Point(0,-1));
						return Direction.SOUTH;
				}
			}
		
		return Direction.NOWHERE;
	}
	
	public boolean isParked() {
		return true;
	}
	
	public String toString() {
		
		String car = "Car" + " [id = " + this.ID + 
				", location = [x=" + (int)this.location.getX()  + ", y="+ (int)this.location.getY() + 
				" ], destination = [x="+ (int)this.destination.getX() +", y="+ (int)this.destination.getY() + "]]";
		return car;
	}
	
	public Point getDestination() {
		
		return this.destination;
	}
	
	public Point getLocation() {
	
		return this.location;
	}

	public String getID() {
		
		return this.ID;
	}
}
