import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;
/*********************************************************************************************************************************************
 * File Name: 	Assessment Class
 * Purpose:		Assessment class reads the courseName and studentName from the text file and add them to array list
 * 
 * members:		String assessmentName:			contains the text String from the first text file.
 * 				float gradeReceived:				contains the float value from the second file.
 * 				float outOfGrade:				contains the float value from the first file.
 * 
 * Methods:		boolean processCourseFile:		Reads the text file and add the assessmentName
 * 												and outOfGrade from the courseFile.
 * 												If everything is OK, it returns true to processCategoryFile Method	
 * 												in GradeCategory Class.
 * 				boolean processStudentFile:		Reads the text file and add the gradeReceived from the Student text
 * 												File. If everything is OK, it returns true to processStudentCategoryFile
 * 												Method in GradeCategory Class.
 * 
 * 				String getassessmentName:		returns the assessment Name in String type.
 * 				float getgradeReceived:			return the greadeReceived in float.
 * 				float getoutOfGrade:				return the outOfGrade in float.
 * 
 * Course Name: Computer Engineering Technology & Computing Science
 * Lab Section: 300
 * 	
 * @author Fleming Patel
 * Professor: Linda Crane
 * Assignment: 3
 * 
 *********************************************************************************************************************************************/
public class Assessment {

	private String assessmentName;
	private float gradeReceived;
	private float outOfGrade;

	public Assessment() {
		this.assessmentName = assessmentName; // by default value is null
		this.gradeReceived = gradeReceived;
		this.outOfGrade = outOfGrade;
	}

	public boolean processAssessmentFile(Scanner courseFile) {
		try {
			this.assessmentName = courseFile.next();
			this.outOfGrade = courseFile.nextFloat();
		} catch (InputMismatchException ex) {
			System.out.println("Information is in different format ");
			return false;
		} catch (NoSuchElementException ex) {
			System.out.println("Can not find any type of element ");
			return false;
		}
		return true;
	}

	public boolean processStudentAssessmentFile(Scanner courseFile) {
		try {
			this.gradeReceived = courseFile.nextFloat();
		} catch (InputMismatchException ex) {
			System.out.println("Information is in different format ");
			return false;
		} catch (NoSuchElementException ex) {
			System.out.println("Can not find any type of element ");
			return false;
		}
		return true;
	}

	public String getassessmentName() {
		return this.assessmentName;
	}

	public float getgradeReceived() {
		return this.gradeReceived;
	}

	public float getoutOfGrade() {
		return this.outOfGrade;
	}
}
