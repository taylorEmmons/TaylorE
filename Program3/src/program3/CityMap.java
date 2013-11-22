package program3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Animates the movement of a Car on a city map. The city map is shown in
 * Cartesian coordinates where the origin (0, 0) is at the left bottom corner.
 * 
 * @author amit
 * @author mvail
 * @author tcole
 * @author tim
 * 
 */
public class CityMap extends JPanel
{
	private Car car;
	private int displaySize = 800;
	private int blockSize;
	private int carSize;
	private int offset;
	private int numBlocks;
	private int delay = 500; // milliseconds

	/**
	 * 
	 * @param car
	 *            The Car object to animate on the city map
	 * @param gridSize
	 *            The size of the grid: from (0,0) to (gridSize,gridSize)
	 */
	public CityMap(Car car, int gridSize)
	{
		this.car = car;
		numBlocks = gridSize;
		blockSize = displaySize / (numBlocks + 1);
		offset = blockSize;
		carSize = blockSize / 4;
		setBackground(Color.white);
		setPreferredSize(new Dimension(displaySize, displaySize));
		startAnimation();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics obj)
	{
		Graphics2D page = (Graphics2D) obj;
		super.paintComponent(page);

		Font font = new Font(Font.MONOSPACED, Font.PLAIN, blockSize / 3);
		page.setFont(font);
		page.setColor(Color.red);
		// draw east-west roads for blocks 0 .. numBlocks - 1
		for (int i = 0; i < numBlocks - 1; i++) {
			page.drawString((numBlocks - i - 1) + "", offset / 2, i * blockSize
					+ offset);
			for (int j = 0; j < numBlocks; j++) {
				page.drawLine(i * blockSize + offset, j * blockSize + offset,
						(i + 1) * blockSize + offset, j * blockSize + offset);
			}
		}
		page.drawString(0 + "", offset / 2, (numBlocks - 1) * blockSize
				+ offset);

		// draw north-south roads for blocks 0 .. numBlocks - 1
		for (int i = 0; i < numBlocks; i++) {
			page.drawString(i + "", i * blockSize + offset, offset / 2);
			for (int j = 0; j < numBlocks - 1; j++) {
				page.drawLine(i * blockSize + offset, j * blockSize + offset, i
						* blockSize + offset, (j + 1) * blockSize + offset);
			}
		}

		Point where = car.getLocation();
		page.setColor(Color.blue);
		page.fillRect(where.x * blockSize + offset - carSize / 2,
				(numBlocks - 1 - where.y) * blockSize + offset - carSize / 2,
				carSize, carSize);

		car.nextMove();
	}

	/**
	 * Create an animation thread that runs periodically
	 */
	private void startAnimation()
	{
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				repaint();
			}
		};
		new Timer(delay, taskPerformer).start();
	}

}
