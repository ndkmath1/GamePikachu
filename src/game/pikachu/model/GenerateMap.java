package game.pikachu.model;

import java.util.Random;

/**
 * The GenerateMap class is used to generate a map game
 *
 * @author Khanh
 */
public class GenerateMap implements IGenerateMap {

	private int array[][];
	private IInformation information;

	/**
	 * Construct newly GenerateMap with parameter
	 *
	 * @param information
	 *            information of map game
	 */
	public GenerateMap(IInformation information) {
		this.information = information;
		array = new int[information.getRows()][information.getCols()];
		generateMap();
	}

	/**
	 * Construct newly GenerateMap with parameter
	 *
	 * @param array
	 *            an array
	 */
	public GenerateMap(int[][] array) {
		this.array = array;
	}

	/**
	 * Generate map
	 */
	public void generateMap() {
		int numImage = information.getNumImage();
		int numAppearAnImage = information.getNumAppearAnImage();
		int rows = information.getRows();
		int cols = information.getCols();
		int arr[] = new int[numImage];
		int arrCount[] = new int[numImage];

		for (int i = 1; i <= numImage; i++) {
			arr[i - 1] = i;
			arrCount[i - 1] = 0;
		}
		Random rd = new Random();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int random = rd.nextInt(numImage);
				if (arrCount[random] == numAppearAnImage) {
					random = (random + 1) % numImage;
					while (arrCount[random] == numAppearAnImage) {
						random = (random + 1) % numImage;
					}
				}
				arrCount[random]++;
				array[i][j] = arr[random];
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IGenerateMap#getArray()
	 */
	@Override
	public int[][] getArray() {
		return array;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IGenerateMap#setArray(int[][])
	 */
	@Override
	public void setArray(int[][] array) {
		this.array = array;
	}

}
