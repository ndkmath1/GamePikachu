package game.pikachu.model;

import java.awt.Point;

/**
 * The Information class store information of map game
 *
 * @author Khanh
 */
public class Information implements IInformation {

	// public static int ROWS = 10;
	// public static int COLS = 16;
	// public static int NUM_APPEAR_AN_IMG = 8;
	// public static int NUM_IMG = COLS * ROWS / NUM_APPEAR_AN_IMG;
	// public static final int IMAGE_SIZE = 56;
	// public static final int PADDING = 1;
	// public static final int CELL_SIZE = IMAGE_SIZE + 2 * PADDING;
	private int rows;
	private int cols;
	private int padding;
	private int numAppearImage;
	private int numImage;
	private int imageSize;
	private int cellSize;
	private Point position;
	private int sumTime;
	private int addTime;
	private int numSuggest;

	/**
	 * Construct newly Information object with parameter
	 *
	 * @param rows
	 *            number row of map
	 * @param cols
	 *            number col of map
	 * @param padding
	 *            padding of image
	 * @param numAppearAnImage
	 *            number appear an image
	 * @param imageSize
	 *            size of image
	 * @param position
	 *            position begin of map
	 * @param sumTime
	 *            total time for game
	 * @param addTime
	 *            time add when two points is eat
	 * @param numSuggest
	 *            number of suggest
	 */
	public Information(int rows, int cols, int padding, int numAppearAnImage, int imageSize, Point position,
			int sumTime, int addTime, int numSuggest) {
		this.rows = rows;
		this.cols = cols;
		this.padding = padding;
		this.numAppearImage = numAppearAnImage;
		this.numImage = rows * cols / numAppearAnImage;
		this.imageSize = imageSize;
		this.cellSize = imageSize + 2 * padding;
		this.position = position;
		this.sumTime = sumTime;
		this.addTime = addTime;
		this.numSuggest = numSuggest;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#getRows()
	 */
	@Override
	public int getRows() {
		return rows;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#setRows(int)
	 */
	@Override
	public void setRows(int rows) {
		this.rows = rows;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#getCols()
	 */
	@Override
	public int getCols() {
		return cols;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#setCols(int)
	 */
	@Override
	public void setCols(int cols) {
		this.cols = cols;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#getImageSize()
	 */
	@Override
	public int getImageSize() {
		return imageSize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#setImageSize(int)
	 */
	@Override
	public void setImageSize(int imageSize) {
		this.imageSize = imageSize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#getPadding()
	 */
	@Override
	public int getPadding() {
		return padding;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#setPadding(int)
	 */
	@Override
	public void setPadding(int padding) {
		this.padding = padding;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#getCellSize()
	 */
	@Override
	public int getCellSize() {
		return cellSize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#setCellSize(int)
	 */
	@Override
	public void setCellSize(int cellSize) {
		this.cellSize = cellSize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#getPosition()
	 */
	@Override
	public Point getPosition() {
		return position;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#setPosition(java.awt.Point)
	 */
	@Override
	public void setPosition(Point position) {
		this.position = position;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#getSumTime()
	 */
	@Override
	public int getSumTime() {
		return sumTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#setSumTime(int)
	 */
	@Override
	public void setSumTime(int sumTime) {
		this.sumTime = sumTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#getAddTime()
	 */
	@Override
	public int getAddTime() {
		return addTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#setAddTime(int)
	 */
	@Override
	public void setAddTime(int addTime) {
		this.addTime = addTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#getNumAppearAnImage()
	 */
	@Override
	public int getNumAppearAnImage() {
		return numAppearImage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#setNumAppearAnImage(int)
	 */
	@Override
	public void setNumAppearAnImage(int numAppearAnImage) {
		this.numAppearImage = numAppearAnImage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#getNumImage()
	 */
	@Override
	public int getNumImage() {
		return numImage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#setNumImage(int)
	 */
	@Override
	public void setNumImage(int numImage) {
		this.numImage = numImage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#getNumSuggest()
	 */
	@Override
	public int getNumSuggest() {
		return numSuggest;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IInformation#setNumSuggest(int)
	 */
	@Override
	public void setNumSuggest(int numSuggest) {
		this.numSuggest = numSuggest;
	}

}
