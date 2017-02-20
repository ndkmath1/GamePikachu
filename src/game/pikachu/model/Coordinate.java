package game.pikachu.model;

import java.awt.Point;

/**
 * The Coordinate class is used to process coordinate
 * 
 * @author Khanh
 *
 */
public class Coordinate implements ICoordinate {

	private int[][] array;
	private Point p1 = new Point(-1, -1);
	private Point p2 = new Point(-1, -1);
	private IInformation information;

	/**
	 * The default constructor
	 */
	public Coordinate() {

	}

	/**
	 * Construct newly Coordinate with parameter
	 * 
	 * @param array
	 *            an array
	 * @param information
	 *            information of map game
	 */
	public Coordinate(int[][] array, IInformation information) {
		this.array = array;
		this.information = information;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.ICoordinate#setCoordinate(int, int)
	 */
	@Override
	public int setCoordinate(int x, int y) {
		int cellSize = information.getCellSize();
		int cols = information.getCols();
		int padding = information.getPadding();
		int imageSize = information.getImageSize();
		int rows = information.getRows();
		int dx = information.getPosition().x;
		int dy = information.getPosition().y;
		int x1 = (x - dx) / cellSize;
		int x2 = (x - dx) % cellSize;
		int y1 = (y - dy) / cellSize;
		int y2 = (y - dy) % cellSize;
		if (x1 > 0 && x1 <= cols && x2 >= padding && x2 <= padding + imageSize) {
			if (y1 > 0 && y1 <= rows && y2 >= padding && y2 <= padding + imageSize) {
				if (array[y1 - 1][x1 - 1] != 0) {
					if (p1.x == -1 && p1.y == -1) {
						p1.y = x1 - 1;
						p1.x = y1 - 1;
						return 1;
					} else if (p2.x == -1 && p2.y == -1 && ((y1 - 1) != p1.x || (x1 - 1) != p1.y)) {
						p2.y = x1 - 1;
						p2.x = y1 - 1;
						// System.out.println("i2 = " + i2 + " | j2 = " + j2);
						return 2;
					} else {
						// System.out.println("i1 = " + i1 + " | j1 = " + j1 + "
						// -- " + "i2 = " + i2 + " | j2 = " + j2);
					}
				}
			}
		}

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.ICoordinate#checkCoordinate(int, int)
	 */
	@Override
	public Point checkCoordinate(int x, int y) {
		int cellSize = information.getCellSize();
		int cols = information.getCols();
		int padding = information.getPadding();
		int imageSize = information.getImageSize();
		int rows = information.getRows();
		int dx = information.getPosition().x;
		int dy = information.getPosition().y;
		int x1 = (x - dx) / cellSize;
		int x2 = (x - dx) % cellSize;
		int y1 = (y - dy) / cellSize;
		int y2 = (y - dy) % cellSize;
		if (x1 > 0 && x1 <= cols && x2 >= padding && x2 <= padding + imageSize) {
			if (y1 > 0 && y1 <= rows && y2 >= padding && y2 <= padding + imageSize) {
				return new Point(y1 - 1, x1 - 1);
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.ICoordinate#reset()
	 */
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		p1 = new Point(-1, -1);
		p2 = new Point(-1, -1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.ICoordinate#setArray(int[][])
	 */
	@Override
	public void setArray(int[][] array) {
		// TODO Auto-generated method stub
		this.array = array;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.ICoordinate#getP1()
	 */
	@Override
	public Point getP1() {
		return p1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.ICoordinate#setP1(java.awt.Point)
	 */
	@Override
	public void setP1(Point p1) {
		this.p1 = p1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.ICoordinate#getP2()
	 */
	@Override
	public Point getP2() {
		return p2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.ICoordinate#setP2(java.awt.Point)
	 */
	@Override
	public void setP2(Point p2) {
		this.p2 = p2;
	}

}
