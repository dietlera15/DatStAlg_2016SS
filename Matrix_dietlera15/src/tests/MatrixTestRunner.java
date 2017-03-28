package tests;

import java.util.Formatter;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import algo.Matrix;

public class MatrixTestRunner {

	public static void main(String[] args) {
		
		// run MatrixTest test methods 
		Result result = JUnitCore.runClasses(MatrixTest.class);
		System.out.println("Test Summary:");
		System.out.println("Number of tests: " + result.getRunCount());
		System.out.println("Number of failures: " + result.getFailureCount());
		for (Failure failure: result.getFailures()) {
			System.out.println(failure.toString());
		}

		if (result.getFailureCount() > 0) {
			return;
		}
		// show Examples
		int[][] aA = { { 1, 2, 3 }, { 4, 5, 6 } }; // A(0,1)=2
		int[][] aB = { { 0, -2, 3 }, { 1, 1, 1 } };
		int[][] aC = { { 1, 2 }, { 0, 1 }, { 4, 0 } };


		Matrix mA = new Matrix(aA);
		Matrix mB = new Matrix(aB);
		printMatrix("A = ", mA);
		printMatrix("B = ", mB);
		printMatrix("A + B = ", mA.add(mB));
		Matrix mC = new Matrix(aC);
		printMatrix("C = ", mC);
		printMatrix("B * C = ", mB.mult(mC));
		
	}
	
	public static void printMatrix(String header, Matrix m) {
		if (header == null || m == null)
			return;

		Formatter fm = new java.util.Formatter(System.out);

		int indent = (header.length() < 10 ? 10 : header.length());

		if (m.numCols() == 0 || m.numRows() == 0) {
			fm.format(header + "EMPTY\n");
		}

		for (int row = 0; row < m.numRows(); row++) {
			if (row == m.numRows() / 2)
				fm.format("%-" + indent + "s|% 4d", header, m.get(row, 0));
			else
				fm.format("%-" + indent + "s|% 4d", "", m.get(row, 0));
			for (int col = 1; col < m.numCols(); col++)
				fm.format("% 4d", m.get(row, col));
			fm.format("|\n");
		}
		fm.format("\n");
		fm.close();
	}


}
