package com.codepumpkin.algorithms.recursion;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * You can read more about N Queen Problem Using Recursive Backtracking at 
 * http://codepumpkin.com/n-queen-problem/
 * 
 * @author codepumpkin.com
 *
 */
public class NQueenProblem {

	public static PrintWriter out = new PrintWriter(System.out);
	public static QueenPosition[] p;

	public static void main(String[] args) {

		System.out.println("Enter Number of Queens");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		p = new QueenPosition[n];
		if (getSolution(n, 0)) {
			int[][] result = new int[n][n];

			Arrays.stream(p).forEach(po -> result[po.row][po.col] = 1);

			out.println("Display using Stream API \n-----------------------");

			Arrays.stream(result).forEach(rw -> {
				Arrays.stream(rw).forEach(rw1 -> out.print(rw1 + " "));
				out.println();
			});

			out.println("\n\nDisplay using normal For loop \n---------------------------");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					out.print(result[i][j] + " ");
				}
				out.println();
			}
		} else {
			out.println("Solution not available.");
		}

		out.flush();

	}

	public static boolean getSolution(int n, int row) {
		if (n == 2 || n == 3)
			return false;

		if (row == n)
			return true;

		for (int col = 0; col < n; col++) {
			boolean isSafe = true;
			p[row] = new QueenPosition(row, col);

			for (int placedQueen = 0; placedQueen < row; placedQueen++) {
				if (p[placedQueen].col == col || p[placedQueen].row - p[placedQueen].col == row - col
						|| p[placedQueen].row + p[placedQueen].col == row + col) {
					isSafe = false;
				}
			}

			if (isSafe) {
				if (getSolution(n, row + 1))
					return true;
			}
		}
		return false;
	}
}

class QueenPosition {
	int row;
	int col;

	public QueenPosition(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
}
