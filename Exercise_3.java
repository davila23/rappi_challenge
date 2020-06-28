package test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

	private static int valI;
	private static int valJ;

	public static int getScore(String s) {

		int[][] matriz = findPalindrome(s);

		System.out.println("----  ----  ----  ----  ----  ----  ----  ----  ");
		System.out.println("                   Matriz                       ");
		System.out.println("----  ----  ----  ----  ----  ----  ----  ----  ");

		// printMatrix(matriz);

		/*
		 * int maximo1 = maximMat(matriz); int maximo2 = secondMaxim(matriz, maximo1);
		 * 
		 * System.out.println("MAXIMO : " + maximo1);
		 * 
		 * System.out.println("SEGUNDO MAXIMO : " + maximo2);
		 * 
		 * System.out.println("RESULTADO : " + maximo1 * maximo2);
		 * 
		 * return maximo1 * maximo2;
		 */

		return prodMax(matriz);

	}

	public static int[][] findPalindrome(String A) {

		// Convierto A en Char's

		char[] chars = A.toCharArray();

		int[][] LP = new int[A.length()][A.length()];

		// Toda letra por si sola es palindrome, seteo la diagonal = 1

		for (int i = 0; i < A.length(); i++) {
			LP[i][i] = 1;
		}

		for (int sublen = 2; sublen <= chars.length; sublen++) {
			for (int i = 0; i <= LP.length - sublen; i++) {
				int j = i + sublen - 1;
				// Cuando estan pegados vale 2
				if (chars[i] == chars[j] && sublen == 2) {
					LP[i][j] = 2;
					printMatrix(LP);
				}

				// Cuando hay diferencia entre las posiciones
				else if (chars[i] == chars[j]) {

					LP[i][j] = LP[i + 1][j - 1] + 2;
					printMatrix(LP);
				} else {

					LP[i][j] = Math.max(LP[i + 1][j], LP[i][j - 1]);
					printMatrix(LP);
				}
			}
		}
		printMatrix(LP);
		return LP;

	}

	public static void printMatrix(int[][] LP) {
		for (int i = 0; i < LP.length; i++) {
			for (int j = 0; j < LP.length; j++) {
				System.out.print("  " + LP[i][j]);
			}
			System.out.println("");
		}
		System.out.println(" \n");

	}

	// Producto máximo de la matriz
	public static int prodMax(int[][] mat) {
		int maxProd = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length - 1; j++) {
				maxProd = Math.max(maxProd, mat[i][j] * mat[j + 1][mat.length - 1]);

			}
		}
		return maxProd;
	}

	// Encontrar el valor máximo de la matriz
	public static int maximMat(int[][] mat) {
		int max = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] >= max) {
					max = mat[i][j];
				}
				valI = i;
				valJ = j;
			}
		}
		return max;
	}

	// Encontrar el segundo valor máximo de la matriz
	public static int secondMaxim(int[][] mat, int max) {

		int max2 = 0;
		for (int i = 0; i < mat.length; i++) {

			for (int j = 0; j < mat[i].length; j++) {

				// Si es mayor que max2 PERO menor que max
				if (mat[i][j] > max2 && mat[i][j] <= max && i < valJ + 1) {
					max2 = mat[i][j];
				}
			}
		}
		return max2;
	}
}

public class Exercise_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		int result = Solution.getScore(s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
