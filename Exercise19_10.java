//Objective: Follow the 3 demo videos of Copy File, Object IO, and Split Large to create 3 projects this week.
//Created by:Sebastian Xayaphet
//Date: 7/26/2023
//Version:jdk-20

import java.io.*;

public class Exercise19_10 {
	
	public static void main(String[]args) throws IOException {
		
		if (args.length != 2) {
			System.out.println("Usage: java Exercise19_10 SourceFile numberOfPieces");
			System.exit(0);
		}
		
		BufferedInputStream input = new BufferedInputStream( new FileInputStream(new File(args[0])));
		
		int numberOfPieces = Integer.parseInt(args[1]);
		
		System.out.println("File size: " + input.available() + "bytes ");
		long fileSize = input.available();
		int splitFileSize = (int) Math.ceil(1.0 * fileSize /numberOfPieces);
		
		for (int i =1; i <= numberOfPieces; i++) {
			BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(new File(args[0] + "." + i)));
			
			int value;
			int count =0;
			
			while(count++ < splitFileSize && (value = input.read()) != -1 ) {
				output.write(value);	
			}
			
			output.close();
		}
		
		input.close();
	}

}
