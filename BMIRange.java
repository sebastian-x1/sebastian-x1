// Sebastian Xayaphet
// 2/7/2023
// Write a program to ask the user to input his estimated BMI,
// then display the associated weight status listed in the table

import java.util.Scanner;

public class BMIRange {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please input your BMI: ");
		int bmi = input.nextInt();
		// Display result
		if (bmi < 18.5)
			System.out.println("Your weight status is: Underweight");
		else if (bmi <=25.0)
			System.out.println("Your weight status is: Normal");
		else if (bmi <= 30)
			System.out.println("Your weight status is: Overweight");
		else 
			System.out.println("Your weight status is: Obese");
	} 
}