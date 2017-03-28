package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import algo.Matrix;

public class MatrixTest {

	@Test
	public void testMatrixIntInt() {
		int numRows = 5, numCols = 7;
		Matrix m = new Matrix(numRows, numCols);
		checkSize(m, numRows, numCols);
	}

	@Test
	public void testMatrixIntIntInt() {
		int numRows = 3, numCols = 4, val = 7;
		Matrix m = new Matrix(numRows, numCols, val);
		checkSize(m, numRows, numCols);
		// check all elements
		for (int row=0; row<numRows; row++)
			for (int col=0; col<numCols; col++) 
				assertEquals("unexpected element value", val, m.get(row, col));
	}

	@Test
	public void testMatrixIntArrayArray() {
		int[][] aA = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; // A(0,1)=2
		int numRows = aA.length, numCols = aA[0].length;
		Matrix m = new Matrix(aA);
		
		checkSize(m, numRows, numCols);
		compare2array(m, aA);
	}

	@Test
	public void testAdd() {
		// operands
		int[][] aA = { { 1, 2, 3 }, { 4, 5, 6 } }; // A(0,1)=2
		int[][] aB = { { 0, -2, 3 }, { 1, 1, 1 } }; 
	
		// expected results
		int[][] aExp = { { 1, 0, 6 }, { 5, 6, 7 } }; // A*(-1)
		
		int numRows = aExp.length, numCols = aExp[0].length;
		Matrix mA = new Matrix(aA);
		Matrix mB = new Matrix(aB);
		Matrix mExp = mA.add(mB);
		
		checkSize(mExp, numRows, numCols);
		compare2array(mExp, aExp);
		
	}

	@Test
	public void testMultMatrix() {
		// operands
		int[][] aA = { { 3, 2, 1 }, { 1, 0, 2 } };
		int[][] aB = { { 1, 2 }, { 0, 1 }, { 4, 0 } };

		// expected result
		int[][] aExp = { { 7, 8 }, { 9, 2 } }; // B*C
		
		int numRows = aExp.length, numCols = aExp[0].length;
		Matrix mA = new Matrix(aA);
		Matrix mB = new Matrix(aB);
		Matrix mExp = mA.mult(mB);
		
		checkSize(mExp, numRows, numCols);
		compare2array(mExp, aExp);
	}

	@Test
	public void testMultInt() {
		// operands
		int[][] aA = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; // A(0,1)=2

		// expected results
		int[][] aExp = { { -1, -2, -3 }, { -4, -5, -6 }, { -7, -8, -9 } }; // A*(-1)

		int numRows = aExp.length, numCols = aExp[0].length;
		Matrix mA = new Matrix(aA);
		Matrix mExp = mA.mult(-1);
		
		checkSize(mExp, numRows, numCols);
		compare2array(mExp, aExp);

	}

	@Test
	public void testEqualsMatrix() {
		int[][] aA = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; // A(0,1)=2
		int[][] aB = { { 3, 2, 1 }, { 1, 0, 2 } };

		Matrix mA = new Matrix(aA);
		Matrix mB = new Matrix(aB);
		Matrix mC = new Matrix(aA);
		
		assertEquals("Matrix A equals Matrix B", false, mA.equals(mB));
		assertEquals("Matrix A equals Matrix A", true, mA.equals(mC));
		
	}
	
	private void checkSize(Matrix m, int numRows, int numCols) {
		int daten[][] = m.getDaten();
		assertNotEquals(daten, null);
		assertEquals("unexpected value of numRows ", numRows, m.numRows());
		assertEquals("unexpected value of numCols", numCols, m.numCols());
		assertEquals("unexpected daten.length", numRows, daten.length);
		for (int row=0; row<numRows; row++) {
			assertEquals("unexpected daten["+row+"].length", numCols, daten[row].length);	
		}
	}
	
	private void compare2array(Matrix result, int[][] expected) {
		int[][] daten = result.getDaten();
		assertEquals("unexpected row number", expected.length, daten.length);
		for (int row=0; row<expected.length; row++) {
			assertEquals("unexpected column ["+row+"].length", expected[row].length, daten[row].length);	
			for (int col=0; col<expected[row].length; col++)
				assertEquals("unexpected element value("+row+","+col+")", expected[row][col], daten[row][col]);
		}
	}

}
