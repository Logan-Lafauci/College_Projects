import java.util.Scanner;
/**
 * I will create a program that takes a employee's number of hours worked 
 * calculate the employee's wages and display the calculated result 
 * 
 * CSC 1350 Programming project no 3
 * Section 2
 * 
 * @author Logan Lafauci
 * @since 9-30-2019
 *
 */
public class Prog03_PayCalc {

	public static void main(String[] args) {
		//I am taking in important information from the employee
		Scanner in = new Scanner(System.in);
		int hours = 0;
		double annualPay = 0.0;
		double hourlyPay = 0.0;
		double salary = 0.0;
		System.out.println("Enter Employee ID: ");
		int employeeID = in.nextInt();
		if(employeeID >= 1000) // this checks to see if the employee's ID is in between 1,00 and 2,000
		{
			System.out.println("Enter in the annual salary: ");
			annualPay = in.nextDouble();
		}
		else //This is for the other employees
		{
			System.out.println("Enter the number of hours worked during the week: ");
			hours = in.nextInt();
			System.out.println("Enter the hourly rate: ");
			hourlyPay = in.nextDouble();
		}
		
		//I will now calculate the salary depending on what the employee number is 
		if(employeeID < 1000)
		{
			if(hours > 40)
			{
				double extra = (hours - 40) * hourlyPay * 1.5; 
				salary = extra + hourlyPay * 40;
			}
			else 
			{
				salary = hourlyPay * hours;
			}
		}
		else if(employeeID <= 2000)
		{
			salary = annualPay / 52;
		}
		else
		{
			double annual = annualPay;
			if(annualPay > 75000)
			{
				annual = annualPay + annualPay * .1;
			}
			salary = annual / 52;
		}
		
		//Here is where i will output the calculation and show how it was calculated
		if(employeeID < 1000) 
		{
			System.out.printf("Weekly salary is $%.2f%n",salary);
			if(hours > 40)
			{
				System.out.printf("Salary calculation: 40 hours worked * $%.2f hourly rate + %d extra hours * $%.2f hourly rate = $%.2f a week.", hourlyPay, hours - 40, hourlyPay * 1.5, salary);
			}
			else
			{
				System.out.printf("Salary calculation: %d hours worked * $%.2f hourly rate = $%.2f a week.", hours, hourlyPay, salary);
			}
			
		}
		else if(employeeID <= 2000)
		{
			System.out.printf("Weekly salary is $%.2f%n",salary);
			System.out.printf("Salary calculation: $%.2f annual salary / 52 weeks in a year = $%.2f a week.", annualPay, salary);
		}
		else
		{
			System.out.printf("Weekly salary is $%.2f%n",salary);
			if(annualPay > 75000)
			{
				System.out.printf("Salary calculation: $%.2f annual salary + $%.2f bonus / 52 weeks in a year = $%.2f a week.", annualPay, annualPay *.1, salary);
			}
			else
			{
				System.out.printf("Salary calculation: $%.2f annual salary / 52 weeks in a year = $%.2f a week.", annualPay, salary);
			}
		}
	}
}