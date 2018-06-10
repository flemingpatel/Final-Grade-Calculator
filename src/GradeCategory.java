import java.util.*;
/*********************************************************************************************************************************************
 * File Name: 	GradeCategory Class
 * Purpose:		GradeCategory class reads the categoryName and categoryWeight from the text file which
 * 				passed from Course class and add them to linked list
 * 
 * members:		String categoryName:				contains the categoryName form the first text file	
 * 				float categoryWeight:			contains the categoryWeight form the first text file
 * 				LinkedList assessments:			stores the data in LinkedList
 * 
 * Methods:		boolean processCategoryFile:		Reads the course File and get the regarding next text means the categoryName
 * 												as well as categoryWeight.
 * 												Integer numAssessments stores next integer value form file and we use
 * 												that as our loop size. We pass the courseFile object to newly created
 * 												object of Assessment class. if everything is true form the next class
 * 												it stores the data in Linked list.
 * 				boolean 
 * 				processStudentCategoryFile:		Reads the student File and We pass the courseFile object by assessment Linked
 * 												List reference. if everything is true form the next class
 * 												it returns true.
 * 
 * 				float getcalcGrades:				Calculating the result of the students and returning the average.
 * 				String getcategoryName:			returns the categoryName in String.
 * 				float getcategoryWeight:			returns the categoryWeight in float.
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
public class GradeCategory {

	private String categoryName;
	private LinkedList<Assessment> assessments;
	private float categoryWeight;

	public GradeCategory() {
		assessments = new LinkedList<Assessment>(); // Instantiate the Linked list.
		this.categoryName = categoryName; // by default null
		this.categoryWeight = categoryWeight;

	}

	public boolean processCategoryFile(Scanner courseFile) {
		try {
			this.categoryName = courseFile.next();
			this.categoryWeight = courseFile.nextFloat();
			int numAssessments = courseFile.nextInt();

			for (int i = 0; i < numAssessments; i++) {
				Assessment assessment = new Assessment();
				if (assessment.processAssessmentFile(courseFile)) {
					assessments.add(assessment);
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

	public boolean processStudentCategoryFile(Scanner courseFile) {
		boolean find = false;
		try {
			for (int i = 0; i < assessments.size(); i++) {
				if (assessments.get(i).processStudentAssessmentFile(courseFile)) {
					find = true;
				} else {
					return find;
				}
			}
		} catch (NullPointerException ex) {
			System.out.println("You get NUll Pointer Exception!!!!!!!!");
		}
		return find;
	}

	public String getcategoryName() {
		return this.categoryName;
	}

	public float getcategoryWeight() {
		return this.categoryWeight;
	}

	public float getcalcGrades() {
		float sumofOutOFGrade = 0;
		float sumofReceived = 0;
		float average = 0;
		for (int i = 0; i < assessments.size(); i++) {	
			sumofReceived = assessments.get(i).getgradeReceived();
			sumofOutOFGrade = assessments.get(i).getoutOfGrade();
			average = average + (sumofReceived / sumofOutOFGrade) * (this.categoryWeight / assessments.size());
		}
		return average;
	}
}
