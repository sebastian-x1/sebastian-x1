//Sebastian Xayaphet
//COSC 1173 Lab
//Date: 3/26/2023
//Write a method to convert from Celsius to Fahrenheit using the following method header:
//// convers form Celsius to Fahrenheitpublic static double celsiusToFahrenheit (double celsius)
//The formula for the conversion is: Fahrenheit = ( 9/5) * Celsius +32Write a test program that asks the user to input a Celsius value,
//invoke this method, thenprint out the corresponding Fahrenheit value.
package celsiusToFahrenheit;

import java.util.Scanner;

public class celsiusToFahrenheit {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//declare double celsius and fahrenheit
		System.out.print("Please input the temperature in Celsius: ");
		double celsius = input.nextDouble();
		input.close();
		
		double fahrenheit=celsiusToFahrenheit(celsius);
		System.out.println(celsius + " Celsius equals to " + fahrenheit + "fahrenheit");
		//create a loop from 31 to 40 degrees celsius
		for (int i=40;i>30;i--) {
			celsius = i;
			fahrenheit=celsiusToFahrenheit(celsius);
			System.out.printf(celsius + " Celsius equals to %.1f fahrenheit \n", fahrenheit);
		}

	}
	//invoke a double method and return fahrenheit
	public static double celsiusToFahrenheit(double celsius) {
		double fahrenheit = (((9.0/5.0)* celsius) + 32);
		return fahrenheit;
		
	}
	
}
