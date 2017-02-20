/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.pikachu.model;

import java.awt.Point;

/**
 * The IInformation interface assign method to Information class
 * 
 * @author Khanh
 */
public interface IInformation {

	/**
	 * Get number rows of map game
	 * 
	 * @return number rows of map game
	 */
	public int getRows();

	/**
	 * Set number rows of map game
	 * 
	 * @param rows
	 *            number rows of map game
	 */
	public void setRows(int rows);

	/**
	 * Get number column of map game
	 * 
	 * @return number columns of map game
	 */
	public int getCols();

	/**
	 * Set number columns of map game
	 * 
	 * @param cols
	 *            number column of map game
	 */
	public void setCols(int cols);

	/**
	 * Get size of image
	 * 
	 * @return size of image
	 */
	public int getImageSize();

	/**
	 * Set size of image
	 * 
	 * @param imageSize
	 *            size of image
	 */
	public void setImageSize(int imageSize);

	/**
	 * Get padding of image
	 * 
	 * @return padding of image
	 */
	public int getPadding();

	/**
	 * Set padding of image
	 * 
	 * @param padding
	 *            padding of image
	 */
	public void setPadding(int padding);

	/**
	 * Get number appear an image
	 * 
	 * @return number appear an image
	 */
	public int getNumAppearAnImage();

	/**
	 * Set number appear an image
	 * 
	 * @param numAppearAnImage
	 *            number appear an image
	 */
	public void setNumAppearAnImage(int numAppearAnImage);

	/**
	 * Get number of image
	 * 
	 * @return number of image
	 */
	public int getNumImage();

	/**
	 * Set number of image
	 * 
	 * @param numImage
	 *            number of image
	 */
	public void setNumImage(int numImage);

	/**
	 * Get size of cell
	 * 
	 * @return size of cell
	 */
	public int getCellSize();

	/**
	 * Set size of cell
	 * 
	 * @param cellSize
	 *            size of cell
	 */
	public void setCellSize(int cellSize);

	/**
	 * Get position
	 * 
	 * @return a Point object
	 */
	public Point getPosition();

	/**
	 * Set position
	 * 
	 * @param position
	 *            a Point object
	 */
	public void setPosition(Point position);

	/**
	 * Get total time of game
	 * 
	 * @return sum time of game
	 */
	public int getSumTime();

	/**
	 * Set total time of game
	 * 
	 * @param sumTime
	 *            total time of game
	 */
	public void setSumTime(int sumTime);

	/**
	 * Get time add
	 * 
	 * @return time add
	 */
	public int getAddTime();

	/**
	 * Set time add
	 * 
	 * @param addTime
	 *            time add when two points is eat
	 */
	public void setAddTime(int addTime);

	/**
	 * Get number of suggestions
	 * 
	 * @return number of suggestions
	 */
	public int getNumSuggest();

	/**
	 * Set number of suggestions
	 * 
	 * @param numSuggest
	 *            number of suggestions
	 */
	public void setNumSuggest(int numSuggest);

}