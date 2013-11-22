package solver;

import java.awt.Color;
import java.util.Scanner;

public class Solver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for (int i=0; i<6; i++)
		{
		for (int j=0; j<i; j++)
		System.out.print( "_");
		System.out.println( "*");
		}
		Color [] colors = new Color[3];
		colors[0] = new Color(256,0,0);
		colors[0] = new Color(256,256,256);
		colors[0] = new Color(0,0,256);
		
		
		/*Scanner in = new Scanner(System.in);
		System.out.println("What degrizzle will yo square be? n^2? n^3? just put a 1 for a 1 by 1.. ha or 3 for a 3 by 3");
		int degree = in.nextInt();
		int[][] ms = new int[degree][degree];
		

		for(int i = 0; i < degree; i++) {
			for(int j = 0; j < degree; j++) {
				System.out.println("Enter Value" + i + "," + j +": ");
				ms[i][j] = in.nextInt();
			}
		}*/
	}
}
