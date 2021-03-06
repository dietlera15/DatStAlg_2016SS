package algo;

/**
 * 
 * Implements standard operations on matrices consisting of integer numbers
 * 
 */

public class Matrix {

	private int[][] daten; // 2-dimensional int-array for storing Matrix
							// elements
	private int numRows, numCols; // number of rows and columns

	/**
	 * Create a new Matrix
	 * 
	 * @param numRows
	 *            number of rows
	 * @param numCols
	 *            number of columns
	 */
	public Matrix(int numRows, int numCols) {
		// Begin Implementation
		daten = new int [numRows][numCols];
		this.numRows = numRows;
		this.numCols = numCols;
		// End Implementation
	}

	/**
	 * Create a new Matrix and initializes all fields with a given value
	 * 
	 * @param numRows
	 *            number of rows
	 * @param numCols
	 *            number of columns
	 * @param val
	 *            initialization value
	 */
	public Matrix(int numRows, int numCols, int val) {
		// Begin Implementation
		daten = new int [numRows][numCols];
		this.numRows = numRows;
		this.numCols = numCols;
		for(int i = 0; i < daten.length; i++) {
			for (int j = 0; j < daten[i].length; j++) {
				daten[i][j] = val;
				}
			}
		// End Implementation
	}

	/**
	 * Create a new Matrix from a 2-dimensional array
	 * 
	 * @param a
	 *            array holding the matrix values
	 */
	public Matrix(int[][] a) {
		// Begin Implementation
		daten = a;
		numRows = daten.length;
		numCols = daten[0].length;
		// End Implementation
	}

	/**
	 * Get the number of rows of the matrix
	 * 
	 * @return number of rows
	 */
	public int numRows() {
		return this.numRows;
	}

	/**
	 * Get the number of columns of the matrix
	 * 
	 * @return number of columns
	 */
	public int numCols() {
		return this.numCols;
	}

	/**
	 * Add Matrix m to this Matrix and return the result as new Matrix
	 * 
	 * @param m
	 *            Matrix to be added to this Matrix
	 * @return new Matrix representing the result
	 */
	public Matrix add(Matrix m) {
		// Begin Implementation
		Matrix n = new Matrix(m.numRows(), m.numCols());
		for(int i = 0; i < daten.length; i++) {
			for (int j = 0; j < daten[i].length; j++) {
				n.set((daten[i][j] + m.get(i, j)), i, j);
				}
			}
		return n;
		// End Implementation
	}

	/**
	 * Multiply Matrix m with this Matrix and return the result as new Matrix
	 * 
	 * @param m
	 *            Matrix to be multiplied with this Matrix
	 * @return new Matrix representing the result
	 */
	public Matrix mult(Matrix m) {
		// Begin Implementation
		Matrix n = new Matrix(numRows, m.numCols());
		for(int i = 0; i < numRows; i++) {
			for (int j = 0; j < m.numCols(); j++) {
				int ij = 0;
				for (int k = 0; k < m.numRows(); k++) {
					ij = ij + (daten[i][k] * m.get(k, j));
				}
				n.set(ij, i, j);
			}
		}
		return n;
		// End Implementation
	}

	/**
	 * Multiply a scalar integer value with this Matrix and return the result as
	 * new Matrix
	 * 
	 * @param k
	 *            scalar integer value
	 * @return new Matrix representing the result
	 */
	public Matrix mult(int k) {
		// Begin Implementation
		Matrix n = new Matrix(numRows, numCols);
		for(int i = 0; i < n.numRows(); i++) {
			for (int j = 0; j < n.numCols(); j++) {
				n.set((daten[i][j] * k), i, j);
				}
			}
		return n;
		// End Implementation
	}

	/**
	 * Compare if Matrix m equals this Matrix by comparing all elements
	 * 
	 * @param m
	 *            Matrix to compare to this Matrix
	 * @return result of the compare operation
	 */
	public boolean equals(Matrix m) {
		// Begin Implementation
		for(int i = 0; i < daten.length; i++) {
			for (int j = 0; j < daten[i].length; j++) {
				if(daten[i][j] != m.get(i, j)) return false;
				}
			}
		return true; // change it
		// End Implementation
	}

	/**
	 * Get the element value on the given row and column position
	 * 
	 * @param row
	 * @param col
	 * @return element value
	 */
	public int get(int row, int col) {

		return daten[row][col];
	}

	/**
	 * Set the element value on the given row and column position
	 * 
	 * @param val
	 * @param row
	 * @param col
	 */
	public void set(int val, int row, int col) {

		if (daten != null)
			daten[row][col] = val;
		return;
	}

	/**
	 * Set all elements of the Matrix to the given value
	 * 
	 * @param val
	 */
	public void setAll(int val) {

		for (int row = 0; row < numRows; row++)
			for (int col = 0; col < numCols; col++)
				daten[row][col] = val;
	}
	
	/**
	 * Return the daten attribute holding the 2-dimensinal int array for the Matix elements
	 * @return daten 2-dim arry
	 */
	public int[][] getDaten() {
		return this.daten;
	}

}
