//Sebastian Xayaphet
//Professor Yera
//10/20/23
//Module 6: Lab 6
//The popularity ranking of baby names from years 2001 to 2010 is downloaded from www.ssa.gov/oact/babynames and stored in files named babynameranking2001.txt, babynameranking2002.txt, . . . ,
//babynameranking2010.txt. Each file contains one thousand lines. Each line contains a ranking, a boy’s name, number for the boy’s name, a girl’s name, and number for the girl’s name.
//For example, the first two lines in the file babynameranking2010.txt are as follows:
//1 Jacob 21,875 Isabella 22,731 2 Ethan 17,866 Sophia 20,477
//So, the boy’s name Jacob and girl’s name Isabella are ranked #1 and the boy’s name Ethan and girl’s name Sophia are ranked #2. 21,875 boys are named
//Jacob and 22,731 girls are named Isabella.
//Write a program that prompts the user to enter the year, gender, and followed by a name, and displays the ranking of the name for the year.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BabyNameRanking {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the year
        System.out.print("Enter the year: ");
        int year = input.nextInt();
   
        // Prompt the user to enter the gender
        System.out.print("Enter the gender (M/F): ");
        String gender = input.next();

        // Prompt the user to enter the name
        System.out.print("Enter the name: ");
        String name = input.next();

        // Construct the filename for the selected year
        String fileName = "babynameranking" + year + ".txt";

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            int rank = 0;
            boolean found = false;

            // Read lines from the file
            while (fileScanner.hasNextLine()) {
                rank++;
                String line = fileScanner.nextLine();
                String[] parts = line.split(" ");

                if (parts.length >= 4) {
                    String boyName = parts[1];
                    String girlName = parts[3];
                    
                    if (gender.equals("M") && name.equals(boyName)) {
                        System.out.println(name + " is ranked #" + rank + " in year " + year + ".");
                        found = true;
                        break;
                    } else if (gender.equals("F") && name.equals(girlName)) {
                        System.out.println(name + " is ranked #" + rank + " in year " + year + ".");
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("The name " + name + " is not ranked in year " + year + ".");
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File for the specified year was not found.");
        }

        input.close();
    }
}
