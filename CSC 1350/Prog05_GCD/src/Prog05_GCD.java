/**
* This is a project where i will compare two different numbers
* to find the greatest common divisor 
* 
* CSC 1350 Programming project No 2
* Section 2
* 
* @author Logan Lafauci
* @since 10/14/2019
*/
import java.util.Scanner;

public class Prog05_GCD {

	public static void main(String[] args) {
		//Asking the user to input two positive integers 
		boolean check = true;
		int first = 0;
		int second = 0;
		int gcd = 0;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter first number: ");
		do
		{
			while(!in.hasNextInt()) 
			{
				String bad = in.next();
				System.out.printf("%n%n");
				System.out.println("Value entered is not an integer above zero: " + bad);
				System.out.printf("%n");
				System.out.print("Enter first number: ");
				
			}
			first = in.nextInt();
			if(first > 0)
			{
				check = false;
			}
			else
			{
				System.out.printf("%n%n");
				System.out.println("Value entered is not an integer above zero: " + first);
				System.out.printf("%n");
				System.out.print("Enter first number: ");
			}
		}while(check);
		check = true;
		
		System.out.print("Enter second number: ");
		do
		{
			while(!in.hasNextInt()) 
			{
				String bad = in.next();
				System.out.printf("%n%n");
				System.out.println("Value entered is not an integer above zero: " + bad);
				System.out.printf("%n");
				System.out.print("Enter second number: ");
				
			}
			second = in.nextInt();
			if(second > 0)
			{
				check = false;
			}
			else
			{
				System.out.printf("%n%n");
				System.out.println("Value entered is not an integer above zero: " + second);
				System.out.printf("%n");
				System.out.print("Enter second number: ");
			}
		}while(check);
		System.out.printf("%n%n");
				
		//Calculating the greatest common divisor
		for(int i = 1; i <= first; i++)
		{
			if(first % i == 0 && second % i == 0 && gcd < i)
			{
				gcd = i;
			}
		}
		
		//Printing out the information such as the gcd and the divisors for the first and second number
		System.out.printf("The greatest common divisor of %d and %d is %d.%n%n%n", first, second, gcd);
		System.out.printf("Divisor for %d:%n", first);
		for(int i = 1; i <= first; i++)
		{
			if(first % i == 0)
			{
				System.out.println(i);
			}
		}
		System.out.printf("%n%n");
		System.out.printf("Divisor for %d:%n", second);
		for(int i = 1; i <= second; i++)
		{
			if(second % i == 0)
			{
				System.out.println(i);
			}
		}
	}

}
