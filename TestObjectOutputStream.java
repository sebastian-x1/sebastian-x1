//Objective: Follow the 3 demo videos of Copy File, Object IO, and Split Large to create 3 projects this week.
//Created by:Sebastian Xayaphet
//Date: 7/26/2023
//Version:jdk-20

import java.io.*;

public class TestObjectOutputStream {
	public static void main(String[]args) throws IOException {
		
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("object.dat"));
		
		output.writeUTF(" John ");
		output.writeDouble( 85.5 );
		output.writeObject(new java.util.Date());
		
		output.close();
	}
}
