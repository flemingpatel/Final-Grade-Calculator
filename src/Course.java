import java.util.*;
/*********************************************************************************************************************************************
 * File Name: 	Course Class
 * Purpose:		Course class reads the courseName and studentName from the text file and add them to array list
 * 
 * members:		String coursName:			contains the first text means course name form the first text file	
 * 				String studentName:			contains the first text means Student name form the second text file
 * 				ArrayList allGrades:			Stores the data in array list which linked to linked list	
 * 
 * Methods:		boolean processCourseFile:		Reads the course File and get the first text means the course name.
 * 												Integer numCategories stores next integer value form file and we use
 * 												that as our loop size. We pass the courseFile object to newly created
 * 												object of GradeCategory class. if everything is true form the next class
 * 												it stores the data in array list.
 * 				boolean processStudentFile:		Reads the student File and get the first text means the student name.
 * 												We loop through the array list size. We pass the courseFile by allGreads arrayList.
 * 												if everything is true form the next class
 * 												it returns true.
 * 
 * 				void display:					This method displays appropriate output.
 * 				void finalGrade:					It calculate the final grades and print it.
 * 				String getCourseName:			returns the courseName String.
 * 				String getStudentName:			returns the studentName String.
 * 		
 * 
 * Course Name: Computer Engineering Technology & Computing Science
 * Lab Section: 300
 * 	
 * @author Fleming Patel
 * Professor: Linda Crane
 * Assignment: 3
 * 
 *********************************************************************************************************************************************/
public class Course {

	private String courseName;
	private String studentName;
	private ArrayList<GradeCategory> allGrades;

	public Course() {
		allGrades = new ArrayList<GradeCategory>(); // Instantiate the Array list.
		this.courseName = courseName; // by default is null
		this.studentName = studentName; // by default is null
	}

	public boolean processCourseFile(Scanner courseFile) {

		try {
			this.courseName = courseFile.next();
			int numCategories = courseFile.nextInt();

			for (int i = 0; i < numCategories; i++) {
				GradeCategory grade = new GradeCategory();
				if (grade.processCategoryFile(courseFile)) {
					allGrades.add(grade);
				} else {
					return false;
				}
			}
		} catch (InputMismatchException ex) {
			System.out.println("Information is in different format ");
			return false;
		} catch (NoSuchElementException ex) {
			System.out.println("Can not find any type of element ");
			return false;
		}
		return true;
	}

	public boolean processStudentFile(Scanner courseFile) {
		boolean find = false;
		try {
			this.studentName = courseFile.next();
			for (int i = 0; i < allGrades.size(); i++) {
				if (allGrades.get(i).processStudentCategoryFile(courseFile)) {
					find = true;
				} else {
					return find;
				}
			}
		} catch (InputMismatchException ex) {
			System.out.println("Information is in different format ");
			return false;
		} catch (NoSuchElementException ex) {
			System.out.println("Can not find any type of element ");
			return false;
		} catch (NullPointerException ex) {
			System.out.println("You get NUll Pointer Exception!!!!!!!!");
		}
		return find;
	}

	public String getcourseName() {
		return this.courseName;
	}

	public String getstudentName() {
		return this.studentName;
	}

	public void display() {
		System.out.println("\nGrades for " + studentName + " in " + courseName);
		for (int i = 0; i < allGrades.size(); i++) {
			System.out.println(allGrades.get(i).getcategoryName() + " " + allGrades.get(i).getcalcGrades() + " / "
					+ allGrades.get(i).getcategoryWeight());
		}
	}

	public void displayFinalGrade() {
		float finalGrade = 0.0F;
		for (int i = 0; i < allGrades.size(); i++) {
			finalGrade = finalGrade + allGrades.get(i).getcalcGrades();
		}
		System.out.print("Final Grade: " + finalGrade + "\n");
	}
}
