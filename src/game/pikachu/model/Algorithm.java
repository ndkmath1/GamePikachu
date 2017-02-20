package game.pikachu.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * The Algorithm class illustrates for algorithm of game
 *
 * @author Khanh
 */
public class Algorithm implements IAlgorithm {

	private IInformation information;
	private int rows;
	private int cols;
	private int[][] array;
	private List<Point> listPoint; // hold 2, 3 or 4 point
	private Stack<StackPoint> undoStack = new Stack<StackPoint>();
	private Stack<StackPoint> redoStack = new Stack<StackPoint>();

	/**
	 * Construct newly algorithm object with parameter
	 *
	 * @param array
	 *            map of game
	 * @param information
	 *            information of game
	 */
	public Algorithm(int[][] array, IInformation information) {
		this.array = array;
		this.information = information;
		this.rows = information.getRows();
		this.cols = information.getCols();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IAlgorithm#check(int, int, int, int)
	 */
	@Override
	public boolean check(int i1, int j1, int i2, int j2) { // input i1 != i2 ||
		// j1 != j2
		boolean found = false;
		listPoint = new ArrayList<Point>();
		listPoint.add(new Point(i1, j1));
		listPoint.add(new Point(i2, j2));
		if (array[i1][j1] == array[i2][j2]) {

			if (i1 == i2) {
				found = j1 < j2 ? checkRow(i1, j1, j2) || checkRow1(i1, j1, j2)
						: checkRow(i1, j2, j1) || checkRow1(i1, j2, j1);
			} else if (j1 == j2) {
				found = i1 < i2 ? checkCol(j1, i1, i2) || checkCol1(j1, i1, i2)
						: checkCol(j1, i2, i1) || checkCol1(j1, i2, i1);
			} else { // i1 != i2 && j1 != j2
				if (i1 < i2) {
					if (j1 < j2) {
						found = check1(i1, j1, i2, j2);
					} else {
						found = check2(i2, j2, i1, j1);
					}
				} else {
					if (j1 < j2) {
						found = check2(i1, j1, i2, j2);
					} else {
						found = check1(i2, j2, i1, j1);
					}
				}
			}
		}
		if (!found) {
			listPoint.remove(1);
			listPoint.remove(0);
		} else {
			sortListPoint();
		}

		return found;

	}

	/**
	 * Check that between two points of the same row have exist another point or
	 * not
	 * 
	 * @param i
	 *            row of two points
	 * @param j1
	 *            column of the first point
	 * @param j2
	 *            column of the second point
	 * @return true if not exist another point, false if otherwise
	 */
	private boolean checkRow(int i, int j1, int j2) {// input j1 < j2
		int count = 0;
		for (int k = j1 + 1; k < j2; k++) {
			if (array[i][k] == 0) {
				count++;
			} else {
				break;
			}
		}
		return count == (j2 - j1 - 1);

	}

	/**
	 * Check that between two points of the same column have exist another point
	 * or not
	 * 
	 * @param j
	 *            column of two points
	 * @param i1
	 *            row of the first point
	 * @param i2
	 *            row of the second point
	 * @return true if not exist another point, false if otherwise
	 */
	private boolean checkCol(int j, int i1, int i2) {// input i1 < i2

		for (int k = i1 + 1; k < i2; k++) {
			if (array[k][j] != 0) {
				return false;
			}
		}

		return true;

	}

	/**
	 * Check U-shape between two point of the same row
	 * 
	 * @param i
	 *            row of two points
	 * @param j1
	 *            column of the first point
	 * @param j2
	 *            column of the second point
	 * @return true if two points can eat, false if otherwise
	 */
	private boolean checkRow1(int i, int j1, int j2) {
		if (i == 0) {
			listPoint.add(new Point(-1, j1));
			listPoint.add(new Point(-1, j2));
			return true;
		} else if (i == rows - 1) {
			listPoint.add(new Point(rows, j1));
			listPoint.add(new Point(rows, j2));
			return true;
		} else {
			for (int k = i - 1; k >= 0; k--) {
				if (k == 0 && checkCol(j1, k, i) && checkCol(j2, k, i) && array[k][j1] == 0 && array[k][j2] == 0) {
					if (checkRow(k, j1, j2)) {
						listPoint.add(new Point(k, j1));
						listPoint.add(new Point(k, j2));
					} else {
						listPoint.add(new Point(-1, j1));
						listPoint.add(new Point(-1, j2));
					}
					return true;
				} else if (checkCol(j1, k - 1, i) && checkRow(k, j1, j2) && checkCol(j2, k - 1, i)) {
					listPoint.add(new Point(k, j1));
					listPoint.add(new Point(k, j2));
					return true;
				}
			}
			for (int k = i + 1; k < rows; k++) {
				if (k == rows - 1 && checkCol(j1, i, k) && checkCol(j2, i, k) && array[k][j1] == 0
						&& array[k][j2] == 0) {
					if (checkRow(k, j1, j2)) {
						listPoint.add(new Point(k, j1));
						listPoint.add(new Point(k, j2));
					} else {
						listPoint.add(new Point(rows, j1));
						listPoint.add(new Point(rows, j2));
					}
					return true;
				} else if (checkCol(j1, i, k + 1) && checkRow(k, j1, j2) && checkCol(j2, i, k + 1)) {
					listPoint.add(new Point(k, j1));
					listPoint.add(new Point(k, j2));
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Check U-shape between two point of the same column
	 * 
	 * @param j
	 *            column of two points
	 * @param i1
	 *            row of the first point
	 * @param i2
	 *            row of the second point
	 * @return true if two points can eat, false if otherwise
	 */
	private boolean checkCol1(int j, int i1, int i2) {
		if (j == 0) {
			listPoint.add(new Point(i1, -1));
			listPoint.add(new Point(i2, -1));
			return true;
		} else if (j == cols - 1) {
			listPoint.add(new Point(i1, cols));
			listPoint.add(new Point(i2, cols));
			return true;
		} else {
			for (int k = j - 1; k >= 0; k--) {
				if (k == 0 && checkRow(i1, k, j) && checkRow(i2, k, j) && array[i1][k] == 0 && array[i2][k] == 0) {
					if (checkCol(k, i1, i2)) {
						listPoint.add(new Point(i1, k));
						listPoint.add(new Point(i2, k));
					} else {
						listPoint.add(new Point(i1, -1));
						listPoint.add(new Point(i2, -1));
					}
					return true;
				} else if (checkRow(i1, k - 1, j) && checkCol(k, i1, i2) && checkRow(i2, k - 1, j)) {
					listPoint.add(new Point(i1, k));
					listPoint.add(new Point(i2, k));
					return true;
				}
			}
			for (int k = j + 1; k < cols; k++) {
				if (k == cols - 1 && checkRow(i1, j, k) && checkRow(i2, j, k) && array[i1][k] == 0
						&& array[i2][k] == 0) {
					if (checkCol(k, i1, i2)) {
						listPoint.add(new Point(i1, k));
						listPoint.add(new Point(i2, k));
					} else {
						listPoint.add(new Point(i1, cols));
						listPoint.add(new Point(i2, cols));
					}

					return true;
				} else if (checkRow(i1, j, k + 1) && checkCol(k, i1, i2) && checkRow(i2, j, k + 1)) {
					listPoint.add(new Point(i1, k));
					listPoint.add(new Point(i2, k));
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Check two points have not the same row and column (case: i1 < i2 and j1 <
	 * j2)
	 * 
	 * @param i1
	 *            row of the first point
	 * @param j1
	 *            column of the first point
	 * @param i2
	 *            row of the second point
	 * @param j2
	 *            column of the second point
	 * @return true if two points can eat, false if otherwise
	 */
	private boolean check1(int i1, int j1, int i2, int j2) { // input i1 < i2 &&
		// j1 < j2
		if (checkRow(i1, j1, j2) && array[i1][j2] == 0 && checkCol(j2, i1, i2)) { // check
			// L/I
			listPoint.add(new Point(i1, j2));
			return true;
		} else if (checkCol(j1, i1, i2) && array[i2][j1] == 0 && checkRow(i2, j1, j2)) { // check
			// L/I
			listPoint.add(new Point(i2, j1));
			return true;
		} else {
			if (i1 == 0 && checkCol(j2, i1, i2) && array[i1][j2] == 0) {
				listPoint.add(new Point(-1, j1));
				listPoint.add(new Point(-1, j2));
				return true;
			} else if (i2 == rows - 1 && checkCol(j1, i1, i2) && array[i2][j1] == 0) {
				listPoint.add(new Point(rows, j1));
				listPoint.add(new Point(rows, j2));
				return true;
			} else if (j1 == 0 && checkRow(i2, j1, j2) && array[i2][j1] == 0) {
				listPoint.add(new Point(i1, -1));
				listPoint.add(new Point(i2, -1));
				return true;
			} else if (j2 == cols - 1 && checkRow(i1, j1, j2) && array[i1][j2] == 0) {
				listPoint.add(new Point(i1, cols));
				listPoint.add(new Point(i2, cols));
				return true;
			} else {
				for (int k = i1 - 1; k >= 0; k--) {
					if (k == 0 && checkCol(j1, k, i1) && checkCol(j2, k, i2) && array[k][j1] == 0
							&& array[k][j2] == 0) {
						if (checkRow(k, j1, j2)) {
							listPoint.add(new Point(k, j1));
							listPoint.add(new Point(k, j2));
						} else {
							listPoint.add(new Point(-1, j1));
							listPoint.add(new Point(-1, j2));
						}
						return true;
					}
					if (k > 0 && checkCol(j1, k - 1, i1) && checkCol(j2, k - 1, i2) && checkRow(k, j1, j2)) {
						listPoint.add(new Point(k, j1));
						listPoint.add(new Point(k, j2));
						return true;
					}
				}
				for (int k = j1 - 1; k >= 0; k--) {
					if (k == 0 && checkRow(i1, k, j1) && checkRow(i2, k, j2) && array[i1][k] == 0
							&& array[i2][k] == 0) {
						if (checkCol(k, i1, i2)) {
							listPoint.add(new Point(i1, k));
							listPoint.add(new Point(i2, k));
						} else {
							listPoint.add(new Point(i1, -1));
							listPoint.add(new Point(i2, -1));
						}
						return true;
					}
					if (k > 0 && checkRow(i1, k - 1, j1) && checkRow(i2, k - 1, j2) && checkCol(k, i1, i2)) {
						listPoint.add(new Point(i1, k));
						listPoint.add(new Point(i2, k));
						return true;
					}
				}
				for (int k = i1 + 1; k < rows; k++) {
					if (k == i2) {

					} else if (k < i2) {
						if (checkCol(j1, i1, k + 1) && checkRow(k, j1, j2) && checkCol(j2, k - 1, i2)) {
							listPoint.add(new Point(k, j1));
							listPoint.add(new Point(k, j2));
							return true;
						}
					} else {// k > i2
						if (k == rows - 1 && checkCol(j1, i1, k) && checkCol(j2, i2, k) && array[k][j1] == 0
								&& array[k][j2] == 0) {
							if (checkRow(k, j1, j2)) {
								listPoint.add(new Point(k, j1));
								listPoint.add(new Point(k, j2));
							} else {
								listPoint.add(new Point(rows, j1));
								listPoint.add(new Point(rows, j2));
							}
							return true;
						}
						if (k < rows - 1 && checkCol(j1, i1, k + 1) && checkCol(j2, i2, k + 1) && checkRow(k, j1, j2)) {
							listPoint.add(new Point(k, j1));
							listPoint.add(new Point(k, j2));
							return true;
						}
					}
				}
				for (int k = j1 + 1; k < cols; k++) {
					if (k == j2) {

					} else if (k < j2) {
						if (checkRow(i1, j1, k + 1) && checkCol(k, i1, i2) && checkRow(i2, k - 1, j2)) {
							listPoint.add(new Point(i1, k));
							listPoint.add(new Point(i2, k));
							return true;
						}
					} else { // k > j2
						if (k == cols - 1 && checkRow(i1, j1, k) && checkRow(i2, j2, k) && array[i1][k] == 0
								&& array[i2][k] == 0) {
							if (checkCol(k, i1, i2)) {
								listPoint.add(new Point(i1, k));
								listPoint.add(new Point(i2, k));
							} else {
								listPoint.add(new Point(i1, cols));
								listPoint.add(new Point(i2, cols));
							}
							return true;
						}
						if (k < cols - 1 && checkRow(i1, j1, k + 1) && checkRow(i2, j2, k + 1) && checkCol(k, i1, i2)) {
							listPoint.add(new Point(i1, k));
							listPoint.add(new Point(i2, k));
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	/**
	 * Check two points have not the same row and column (case: i1 > i2 and j1 <
	 * j2)
	 * 
	 * @param i1
	 *            row of the first point
	 * @param j1
	 *            column of the first point
	 * @param i2
	 *            row of the second point
	 * @param j2
	 *            column of the second point
	 * @return true if two point can eat, false if otherwise
	 */
	private boolean check2(int i1, int j1, int i2, int j2) { // input i1 > i2 &&
		// j1 < j2
		if (checkCol(j1, i2, i1) && array[i2][j1] == 0 && checkRow(i2, j1, j2)) {
			listPoint.add(new Point(i2, j1));
			return true;
		} else if (checkRow(i1, j1, j2) && array[i1][j2] == 0 && checkCol(j2, i2, i1)) {
			listPoint.add(new Point(i1, j2));
			return true;
		} else {
			if (i2 == 0 && checkCol(j1, i2, i1) && array[i2][j1] == 0) {
				listPoint.add(new Point(-1, j1));
				listPoint.add(new Point(-1, j2));
				return true;
			} else if (j1 == 0 && checkRow(i2, j1, j2) && array[i2][j1] == 0) {
				listPoint.add(new Point(i1, -1));
				listPoint.add(new Point(i2, -1));
				return true;
			} else if (i1 == rows - 1 && checkCol(j2, i2, i1) && array[i1][j2] == 0) {
				listPoint.add(new Point(rows, j1));
				listPoint.add(new Point(rows, j2));
				return true;
			} else if (j2 == cols - 1 && checkRow(i1, j1, j2) && array[i1][j2] == 0) {
				listPoint.add(new Point(i1, cols));
				listPoint.add(new Point(i2, cols));
				return true;
			} else {
				for (int k = i1 + 1; k < rows; k++) {
					if (k == rows - 1 && checkCol(j1, i1, k) && checkCol(j2, i2, k) && array[k][j1] == 0
							&& array[k][j2] == 0) {
						if (checkRow(k, j1, j2)) {
							listPoint.add(new Point(k, j1));
							listPoint.add(new Point(k, j2));
						} else {
							listPoint.add(new Point(rows, j1));
							listPoint.add(new Point(rows, j2));
						}

						return true;
					}
					if (k < rows - 1 && checkCol(j1, i1, k + 1) && checkRow(k, j1, j2) && checkCol(j2, i2, k + 1)) {
						listPoint.add(new Point(k, j1));
						listPoint.add(new Point(k, j2));
						return true;
					}
				}
				for (int k = j1 - 1; k >= 0; k--) {
					if (k == 0 && checkRow(i1, k, j1) && checkRow(i2, k, j2) && array[i1][k] == 0
							&& array[i2][k] == 0) {
						if (checkCol(k, i2, i1)) {
							listPoint.add(new Point(i1, k));
							listPoint.add(new Point(i2, k));
						} else {
							listPoint.add(new Point(i1, -1));
							listPoint.add(new Point(i2, -1));
						}
						return true;
					} else if (k > 0 && checkRow(i1, k - 1, j1) && checkRow(i2, k - 1, j2) && checkCol(k, i2, i1)) {
						listPoint.add(new Point(i1, k));
						listPoint.add(new Point(i2, k));
						return true;
					}
				}
				for (int k = i1 - 1; k >= 0; k--) {
					if (k == i2) {

					} else if (k > i2) {
						if (checkCol(j1, k - 1, i1) && checkRow(k, j1, j2) && checkCol(j2, i2, k + 1)) {
							listPoint.add(new Point(k, j1));
							listPoint.add(new Point(k, j2));
							return true;
						}
					} else {// k < i2
						if (k == 0 && checkCol(j1, k, i1) && checkCol(j2, k, i2) && array[k][j1] == 0
								&& array[k][j2] == 0) {
							if (checkRow(k, j1, j2)) {
								listPoint.add(new Point(k, j1));
								listPoint.add(new Point(k, j2));
							} else {
								listPoint.add(new Point(-1, j1));
								listPoint.add(new Point(-1, j2));
							}
							return true;
						}
						if (k > 0 && checkCol(j1, k - 1, i1) && checkRow(k, j1, j2) && checkCol(j2, k - 1, i2)) {
							listPoint.add(new Point(k, j1));
							listPoint.add(new Point(k, j2));
							return true;
						}
					}
				}
				for (int k = j1 + 1; k < cols; k++) {
					if (k == j2) {

					} else if (k < j2) {
						if (checkRow(i1, j1, k + 1) && checkRow(i2, k - 1, j2) && checkCol(k, i2, i1)) {
							listPoint.add(new Point(i1, k));
							listPoint.add(new Point(i2, k));
							return true;
						}
					} else { // k > j2
						if (k == cols - 1 && checkRow(i1, j1, k) && checkRow(i2, j2, k) && array[i1][k] == 0
								&& array[i2][k] == 0) {
							if (checkCol(k, i1, i2)) {
								listPoint.add(new Point(i1, k));
								listPoint.add(new Point(i2, k));
							} else {
								listPoint.add(new Point(i1, cols));
								listPoint.add(new Point(i2, cols));
							}
							return true;
						}
						if (k < cols - 1 && checkRow(i1, j1, k + 1) && checkCol(k, i2, i1) && checkRow(i2, j2, k + 1)) {
							listPoint.add(new Point(i1, k));
							listPoint.add(new Point(i2, k));
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IAlgorithm#setArray(int[][])
	 */
	@Override
	public void setArray(int[][] array) {
		// TODO Auto-generated method stub
		this.array = array;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IAlgorithm#getListPoint()
	 */
	@Override
	public List<Point> getListPoint() {
		// TODO Auto-generated method stub
		return listPoint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IAlgorithm#sortListPoint()
	 */
	private void sortListPoint() {
		// TODO Auto-generated method stub
		List<Point> tempList = new ArrayList<Point>();
		int size = listPoint.size();
		switch (size) {
		case 2:
			break;
		case 3:
			tempList.add(listPoint.get(0));
			tempList.add(listPoint.get(2));
			tempList.add(listPoint.get(1));
			listPoint = tempList;
			break;
		case 4:
			tempList.add(listPoint.get(0));
			if (checkPoint(listPoint.get(0), listPoint.get(2))) {
				tempList.add(listPoint.get(2));
				tempList.add(listPoint.get(3));
				tempList.add(listPoint.get(1));
			} else {
				tempList.add(listPoint.get(3));
				tempList.add(listPoint.get(2));
				tempList.add(listPoint.get(1));
			}
			listPoint = tempList;
			break;
		default:
			break;
		}
		changeCoordinate(listPoint);
	}

	/**
	 * Check two points have same row or column
	 * 
	 * @param p1
	 *            the first point
	 * @param p2
	 *            the second point
	 * @return true if two point have same row or column, false if otherwise
	 */
	private boolean checkPoint(Point p1, Point p2) {
		return p1.x == p2.x || p1.y == p2.y;
	}

	/**
	 * Change coordinate of the list point
	 * 
	 * @param listPoint
	 *            the list point
	 */
	private void changeCoordinate(List<Point> listPoint) {
		int size = listPoint.size();
		for (int i = 0; i < size; i++) {
			listPoint.set(i, changePoint(listPoint.get(i)));
		}
	}

	/**
	 * Change coordinate of a point
	 * 
	 * @param p
	 *            a point
	 * @return a point have been changed coordinates
	 */
	private Point changePoint(Point p) {
		int cellSize = information.getCellSize();
		Point position = information.getPosition();
		Point q = new Point();
		q.y = position.y + (p.x + 1) * cellSize + cellSize / 2;
		q.x = position.x + (p.y + 1) * cellSize + cellSize / 2;
		return q;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IAlgorithm#suggest()
	 */
	@Override
	public List<Point> suggest() {
		// TODO Auto-generated method stub
		int numImage = information.getNumImage();
		for (int i = 1; i <= numImage; i++) {
			List<Point> list = getList(i);
			int size = list.size();
			for (int j = 0; j < size - 1; j++) {
				for (int k = j + 1; k < size; k++) {
					if (check(list.get(j).x, list.get(j).y, list.get(k).x, list.get(k).y)) {
						// List<Point> result = new ArrayList<Point>();
						// result.add(list.get(j));
						// result.add(list.get(k));
						// return result;
						return listPoint;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Get list point have label
	 *
	 * @param label
	 *            label of image
	 * @return a list point
	 */
	private List<Point> getList(int label) {
		List<Point> list = new ArrayList<Point>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (array[i][j] == label) {
					list.add(new Point(i, j));
				}
			}
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IAlgorithm#swap()
	 */
	@Override
	public void swap() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (array[i][j] != 0) {
					list.add(array[i][j]);
				}
			}
		}
		Random rd = new Random();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (array[i][j] != 0) {
					int index = rd.nextInt(list.size());
					array[i][j] = list.get(index);
					list.remove(index);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IAlgorithm#undo()
	 */
	@Override
	public void undo() {
		if (!undoStack.isEmpty()) {
			StackPoint sp = undoStack.pop();
			redoStack.add(new StackPoint(array, rows, cols));
			copyArray(sp.getArray());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IAlgorithm#redo()
	 */
	@Override
	public void redo() {
		if (!redoStack.isEmpty()) {
			StackPoint sp = redoStack.pop();
			undoStack.add(new StackPoint(array, rows, cols));
			copyArray(sp.getArray());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * game.pikachu.model.IAlgorithm#addStackUndo(game.pikachu.model.StackPoint)
	 */
	@Override
	public void addStackUndo(StackPoint p) {
		undoStack.add(p);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * game.pikachu.model.IAlgorithm#addStackRedo(game.pikachu.model.StackPoint)
	 */
	@Override
	public void addStackRedo(StackPoint p) {
		redoStack.add(p);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IAlgorithm#getArray()
	 */
	@Override
	public int[][] getArray() {
		return array;
	}

	/**
	 * Compare two array
	 *
	 * @param a
	 *            an array
	 * @param b
	 *            an array
	 * @return true if all element is the same, false if otherwise
	 */
	private boolean compareArray(int[][] a, int[][] b) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (a[i][j] != b[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Copy array
	 *
	 * @param array
	 *            an array
	 */
	private void copyArray(int[][] array) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				this.array[i][j] = array[i][j];
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IAlgorithm#getStackUndo()
	 */
	@Override
	public Stack<StackPoint> getStackUndo() {
		return undoStack;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IAlgorithm#getStackRedo()
	 */
	@Override
	public Stack<StackPoint> getStackRedo() {
		return redoStack;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IAlgorithm#moveLeft(java.awt.Point,
	 * java.awt.Point)
	 */
	@Override
	public void moveLeft(Point p1, Point p2) {
		if (p1.y > p2.y) {
			moveLeft(p1);
			moveLeft(p2);
		} else {
			moveLeft(p2);
			moveLeft(p1);
		}
	}

	/**
	 * Move p to the left a position
	 *
	 * @param p
	 *            a Point object
	 */
	private void moveLeft(Point p) {
		for (int j = p.y + 1; j < cols; j++) {
			if (array[p.x][j] != 0) {
				array[p.x][j - 1] = array[p.x][j];
				array[p.x][j] = 0;
			} else {
				break;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IAlgorithm#moveRight(java.awt.Point,
	 * java.awt.Point)
	 */
	@Override
	public void moveRight(Point p1, Point p2) {
		if (p1.y < p2.y) {
			moveRight(p1);
			moveRight(p2);
		} else {
			moveRight(p2);
			moveRight(p1);
		}
	}

	/**
	 * Move p to the right a position
	 *
	 * @param p
	 *            a Point object
	 */
	private void moveRight(Point p) {
		for (int j = p.y - 1; j >= 0; j--) {
			if (array[p.x][j] != 0) {
				array[p.x][j + 1] = array[p.x][j];
				array[p.x][j] = 0;
			} else {
				break;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IAlgorithm#moveTop(java.awt.Point,
	 * java.awt.Point)
	 */
	@Override
	public void moveTop(Point p1, Point p2) {
		if (p1.x > p2.x) {
			moveTop(p1);
			moveTop(p2);
		} else {
			moveTop(p2);
			moveTop(p1);
		}
	}

	/**
	 * Move p to the top a position
	 *
	 * @param p
	 *            a Point object
	 */
	private void moveTop(Point p) {
		for (int i = p.x + 1; i < rows; i++) {
			if (array[i][p.y] != 0) {
				array[i - 1][p.y] = array[i][p.y];
				array[i][p.y] = 0;
			} else {
				break;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IAlgorithm#moveBottom(java.awt.Point,
	 * java.awt.Point)
	 */
	@Override
	public void moveBottom(Point p1, Point p2) {
		if (p1.x < p2.x) {
			moveBottom(p1);
			moveBottom(p2);
		} else {
			moveBottom(p2);
			moveBottom(p1);
		}
	}

	/**
	 * Move p to the bottom a position
	 *
	 * @param p
	 *            a Point object
	 */
	private void moveBottom(Point p) {
		for (int i = p.x - 1; i >= 0; i--) {
			if (array[i][p.y] != 0) {
				array[i + 1][p.y] = array[i][p.y];
				array[i][p.y] = 0;
			} else {
				break;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.model.IAlgorithm#checkEmpty()
	 */
	@Override
	public boolean checkEmpty() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (array[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

}
