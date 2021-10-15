/**
* I will be checking if a student qualifies to be a athlete
* I will compare GPA and hours with the required GPA and hours needed
* 
* CSC 1350 Programming project No 7
* Section 2
* 
* @author Logan Lafauci
* @since 10/28/2019
*/
import java.util.Scanner;

public class Prog07_Qualify {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean student = true;
		int totalStudents = 0;
		int eligible = 0;
		//Allows the user to input information as long as they have info to put in
		while(student)
		{
			int id = 0;
			int year = 0;
			int totalHours = 0;
			int currentHours = 0;
			double gpa = 0;
			boolean classes = true;
			//This takes in all the necessary info to check for the student's qualification
			id = checker("Enter student ID:", 1000, 9999);
			year = checker("Enter student class (1 for Freshman, 2 for Sophomore, 3 for Junior):", 1, 3);
			totalHours = checker("Enter total hours completed before this year:", 0, 100);
			
			//The while loop is for taking in info and calculating it as it's needed.
			while(classes)
			{
				int hours = checker("Enter hours for class:", 1, 5);
				totalHours += hours;
				currentHours += hours;
				int grade = checker("Input class grade value (4 for A, 3 for B, 2 for C, 1 for D, 0 for F)", 0, 4);
				gpa += (double)(grade * hours);
				classes = another("Do you have more classes to enter for this student? (Y/N)");
			}
			gpa = gpa / currentHours;
			
			//This will display the info gathered and determine if someone is  eligible or ineligible 
			System.out.printf("**** Report for student %d ****%n", id);
			System.out.printf("Class:%14d %n", year);
			System.out.printf("Cumulative Hours:  %d %n", totalHours);
			System.out.printf("Current Year GPA:  %.3f %n", gpa);
			if(year == 1 && totalHours >= 25 && gpa >= 1.7)
			{
				System.out.println("*** ELIGIBLE ***");
				System.out.println("");
				eligible ++;
			}
			else if(year == 2 && totalHours >= 50 && gpa >= 1.85)
			{
				System.out.println("*** ELIGIBLE ***");
				System.out.println("");
				eligible ++;
			}
			else if (year == 3 && totalHours >= 85 && gpa >= 1.95)
			{
				System.out.println("*** ELIGIBLE ***");
				System.out.println("");
				eligible ++;
			}
			else
			{
				System.out.println("*** INELIGIBLE ***");
				System.out.println("");
			}
			totalStudents ++;
			
			//This allows the user to enter in more than one student
			student = another("Would you like to enter information for additional student(s)? (Y/N)");
		}
		
		//This shows the summary of how many students the user inputs and how many of them were legible
		System.out.println("*******************************************");
		System.out.println("*           SUMMARY STATISTICS            *");
		System.out.println("*******************************************");
		System.out.printf("%n NUMBER OF STUDENTS PROCESSED:%5d", totalStudents);
		System.out.printf("%n NUMBER FOUND TO BE ELIGIBLE:%6d", eligible);
	}
	
	/**
	 * This method ask a yes or no question to see if the user wants to enter in more information
	 * Developed: 10-28-2019
	 * 
	 * @author Logan Lafauci
	 * @param question ask a question for the user to answer
	 * @return a true or false variable to continue or end a for loop
	 */
	public static boolean another(String question)
	{
		boolean check = true;
		boolean result = false;
		Scanner in = new Scanner(System.in);
		System.out.println(question);
		while(check)
		{
			String answer = in.next();
			if(answer.equals("N"))
			{
				result = false;
				check = false;
			}
			else if(answer.equals("Y"))
			{
				result = true;
				check = false;
			}
			else
			{
				System.out.println("Invalid input");
				System.out.println(question);
			}
		}
		return result;
	}
	
	/**
	 * This method checks all of the integer numbers we need in the program with a question asked and a limit
	 * Developed: 10-28-2019
	 * @author Logan Lafauci
	 * @param question is the question you want the user to answer, lower keeps the number above a certain number I set upper keeps the user from entering a outrageous number 
	 * @return returns the users valid answer
	 */
	public static int checker (String question, int lower, int upper)
	{
		boolean check = true;
		int num = 0;
		Scanner in = new Scanner(System.in);
		System.out.println(question);
		while(check)
		{
			while(!in.hasNextInt())
			{
				String bad = in.next();
				System.out.println("Enter in a valid number");
				System.out.println(question);
			}
			num = in.nextInt();
			if(num >= lower && num <= upper)
			{
				check = false;
			}
			else
			{
				System.out.println("Enter in a valid number");
				System.out.println(question);
			}
		}
		return num;
	}
}
