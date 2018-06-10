# Final-Grade-Calculator
Build a Final Grade Calculator in Java that can be used for any of your courses at Algonquin College.

## Project Description

* Final grades in a course consist of a number of categories (ie Labs, Assignments, Exam, etc.) each of
  which has a weighting (ie 10%, 25%, 30% , etc) which contribute to a total of 100% .
* Program can be used for calculating multiple students grade
* Program handles a variable number of categories in a course.
	* To run the program you will required two text files:
  		- CourseGrading Schema
  		- StudentGrades According to CourseGrading Schema

### Here is the Example of CourseGrading Schema: -
	DataStructures 5
	HybridActivities 5.0 6 HA1 5  HA2 5  HA3 5 HA4 5 HA5 5 HA6 5
	Labs 10.0 7 Lab1 5 Lab2 5 Lab3 5 Lab4 5 Lab5 5 Lab7 5 Lab8 5
	Assignments 25 5 Assign1 20 Assign2 20 Assign3 20 Assign4 20 Assign5 20 
	Midterms/Tests 25.0  3 Midterm1 25 Midterm2 43 LabTest 10 
	FinalExam 35 1 Exam 37

	Breakdown of above example line by line (left to right): -

	- DataStructure: Name of the course
	- 5 represents: Number of categories (ie HybridActivities, Labs, Assignments, etc.)
	- HybridActivities: Name of category
	- 5.0 represents: Weight of category
	- 6 represents: Number of assessments in the category (ie HA1, HA2, HA3, etc.)
	- HA1 represents: Name of assessment
	- 5 represents: assessment outOfGrade

### Here is the Example of StudentGrades According to CourseGrading Schema: -
	Fleming
	5 5 5 5 5 5
	5 5 5 5 5 5 5
	16 17 18 22 17
	25 43 7
	30

	Here each number represents the grade received for assessments  (ie HA1, HA2, HA3, etc.)

### Author

### Fleming Patel
