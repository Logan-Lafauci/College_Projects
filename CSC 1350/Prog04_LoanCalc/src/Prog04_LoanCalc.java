/**
* A program that lets the user enter the loan amount, number of years,
* and display the amortization schedule for the loan
* 
* CSC 1350 Programming project No 2
* Section 2
* 
* @author Logan Lafauci
* @since 10/7/2019
*/
import java.util.Scanner;

public class Prog04_LoanCalc {

	public static void main(String[] args) {
		//Taking in the user input
		double loan = 0;
		int years = 0;
		double rate = 0;
		double interest = 0;
		double payment = 0;
		double principal = 0;
		int timesPaid = 0;
		boolean range = true;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter loan amount (greater than $0.00) : ");
		
		while(true) {
			while(!in.hasNextDouble())
			{
				String bad = in.next();
				System.out.println("Enter a valid number.");
				System.out.println("Enter loan amount (greater than $0.00) : ");
			}
			loan = in.nextDouble();
			if(loan > 0)
			{
				break;
			}
			else
			{
				System.out.println("Enter a valid number.");
				System.out.println("Enter loan amount (greater than $0.00) : ");
			}
		}
		range = true;
		
		System.out.println("Enter loan duration in years (whole number greater than 0) : ");
		while(range) {
			while(!in.hasNextDouble())
			{
				String bad = in.next();
				System.out.println("Enter a valid number.");
				System.out.println("Enter loan duration in years (whole number greater than 0) : ");
			}
			years = in.nextInt();
			if(years > 0)
			{
				range = false;
			}
			else
			{
				System.out.println("Enter a valid number.");
				System.out.println("Enter loan duration in years (whole number greater than 0) : ");
			}
		}
		range = true;
		
		
		
		System.out.println("Enter annual interest rate (value between 0.0 and 100.0) : ");
		while(!in.hasNextDouble())
		{
			String bad = in.next();
			System.out.println("Enter a valid number.");
			System.out.println("Enter annual interest rate (value between 0.0 and 100.0) : ");
		}
		rate = in.nextDouble();
		//make sure rate is in bounds
				
		//here i will make the calculation for the monthly payment, interest, and balance
		payment = ((loan / years) * (1 + rate / 100)) / 12;
		//I am starting to output my information as it is coming in
		System.out.printf("Loan Amount:          $%10.2f%n", loan);
		System.out.printf("Number of Years:      $%10d%n", years);
		System.out.printf("Annual Interest Rate:  %10.2f%n", rate);
		System.out.printf("Monthly Payment:      $%10.2f%n%n%n", payment);
		System.out.println("Payment#      Interest       Principal       Balance");
		while(loan > 0) 
		{
			timesPaid++;
			interest = (rate / 100 / 12) * loan;
			if(loan > payment)
			{
				principal = payment - interest; 
				loan = loan - principal;
			}
			else
			{
				principal = loan;
				loan = 0;
			}
			System.out.printf("%-10d $%10.2f    $%10.2f    $%10.2f%n",timesPaid, interest, principal, loan);
		}
				
	}

}
