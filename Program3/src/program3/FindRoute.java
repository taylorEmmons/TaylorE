package program3;

import java.awt.Point;

public class FindRoute {

	/** Driver for the FindRoute project.
	 * 
	 * @param args an array of four integers containing [x coordinate of car, y coordinate of car, 
	 * x coordinate of destination, ycoordinate of destination] 
	 */
	public static void main(String[] args) 
	{
		if (args.length<5)
		{
			System.err.println( "Usage java FindRoute id Xstart Ystart Xend Yend");
			System.exit(1);
		}
		
		String carID = args[0];
		int xCar = Integer.parseInt(args[1]);
		int yCar = Integer.parseInt(args[2]);
		int xDestination = Integer.parseInt(args[3]);
		int yDestination = Integer.parseInt(args[4]);
		
		Car car = new Car(new Point(xCar,yCar),carID);
		car.setDestination(new Point(xDestination,yDestination));
		System.out.println(car.toString());
		System.out.println("Destination:" + car.getDestination());
		System.out.println("Location: " + car.getLocation());
		
		
		Point Distance = new Point((int) (car.getDestination().getX() - car.getLocation().getX()),
				(int) (car.getDestination().getY() - car.getLocation().getY()));	
		System.out.println("Distance: " + Distance);
		
		int i = 0;
		int k = (int) (Distance.getX() + Distance.getY());
		
		while(i < k) {
			System.out.println(car.nextMove());
			i++;
		}

	}

}
