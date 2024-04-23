// Sebastian Xayaphet
// Date: 2/7/2023
import java.io.*;
class GFG
{
	
	public static double BMI(double height, double weight)
	{
		double bmi = weight / Math.pow(height, 2);
		return bmi;
	}
	public static void main(String[] args) {
	
		double height = 1.79832;
		double weight = 70;
		
		double bmi = BMI(height, weight);
		System.out.print("THe BMI is" +bmi + "so");
		
		if (bmi < 18.5)
			System.out.print("underweight");
		
		else if (bmi >= 18.5 && bmi < 25.0)
			System.out.print("Normal or Healthy");
		
		else if (bmi >= 25.0 && bmi < 30)
			System.out.print("Overweight");
		
		else if (bmi >= 30)
			System.out.print("Obese");
	}
}