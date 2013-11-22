package program3;

import java.awt.Point;

import javax.swing.JFrame;

/**
 * 
 * Takes parameters for a Car object and shows the animated movement of a car to its destination on a city map.
 * 
 * @author amit
 * @author mvail
 * @author tcole
 * @author tim
 * 
 */
public class FindRouteAnimation extends JFrame
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		if (args.length < 5) {
			System.err
					.println("Usage java FindRouteAnimation id Xstart Ystart Xend Yend [gridSize]");
			System.exit(1);
		}

		String id = args[0];
		int xCar = Integer.parseInt(args[1]);
		int yCar = Integer.parseInt(args[2]);
		int xDestination = Integer.parseInt(args[3]);
		int yDestination = Integer.parseInt(args[4]);
		int gridSize = 30; //by default, show 30 x 30 blocks
		if (args.length == 6) 
			gridSize = Integer.parseInt(args[5]);

		Car theCar = new Car(new Point(xCar, yCar), id);
		theCar.setDestination(new Point(xDestination, yDestination));

		JFrame frame = new JFrame("FindRoute GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CityMap panel = new CityMap(theCar, gridSize);

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);

	}

}
