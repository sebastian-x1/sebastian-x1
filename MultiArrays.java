//Sebastian Xayaphet
//COSC 1173 Lab
// Date: 4/9/2023
//Write a program that reads an 3 by 4 matrix and displays the sum of each row separately.

package multiArrays;

import java.util.Scanner;

public class MultiArrays {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double [][] matrix = new double [3][4];
		System.out.println("Enter a 3 by 4 matrix row by row: ");
		for (int i = 0; i<matrix.length; i++) {
			for (int j = 0; j< matrix[i].length; j++) {
				matrix [i][j] = input.nextDouble();
			}
		}
		//compute sum of rows
		double sum= 0.0;
		for (int i = 0; i<matrix.length; i++) {
			sum = 0.0;
			for (int j = 0; j< matrix[i].length; j++) {
				sum += matrix [i][j];
			}
			System.out.println("Sum of the elements at row "+i+" : " +sum);
		}
	}

}
