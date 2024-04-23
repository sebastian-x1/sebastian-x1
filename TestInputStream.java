//Objective: Follow the 3 demo videos of Copy File, Object IO, and Split Large to create 3 projects this week.
//Created by:Sebastian Xayaphet
//Date: 7/26/2023
//Version:jdk-20

import java.io.*;

public class TestInputStream {
	
	public static void main(String[]args) throws IOException, ClassNotFoundException {
		
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("object.dat"));
		
		String name = input.readUTF();
		double score =input.readDouble();
		java.util.Date date =(java.util.Date) (input.readObject());
		
		System.out.println( name + "" + score + "" + date);
		
		input.close();
	}
}
