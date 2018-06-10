import java.util.*;
import java.io.*;
/********************************************************************************************************************
 * File Name: 	Assign3 Class
 * Purpose:		Assign3 class ask the user for course file to read and if the course text file
 * 				work properly then it asks the user for the student file. 
 * 
 * Methods:		Method main				Method main reads the file and transfer all input to Course class
 * 
 * Course Name: Computer Engineering Technology & Computing Science
 * Lab Section: 300
 * 	
 * @author Fleming Patel
 * Professor: Linda Crane
 * Assignment: 3
 * 
 ********************************************************************************************************************/
public class Assign3 {

	public static void main(String[] args) {
		Course course = new Course();
		File file = null;
		File file1 = null;
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		try {
			System.out.println("Enter name of the course file to process: ");
			file = new File(input.nextLine());
			input = new Scanner(file);

			if (course.processCourseFile(input)) {
				System.out.println("Enter name of student file to process: ");
				file1 = new File(input1.nextLine());
				input1 = new Scanner(file1);

				while (input1.hasNext()) {
					if (course.processStudentFile(input1)) {
						course.display();
						course.displayFinalGrade();
					} else {
						break;
					}
				}
			}
		} catch(FileNotFoundException ex) {
			System.out.println("File not found !!!!! please try again ");
		} catch (IOException ex) {
			System.out.println("File input output error ");
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}
}
