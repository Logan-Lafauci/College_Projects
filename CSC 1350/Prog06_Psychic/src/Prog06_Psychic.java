/**
* TOday i'll be creating a program that will test
* if a person can guess a randomly generated number 
* and tally the amount of times they can 
* 
* CSC 1350 Programming project No 6
* Section 2
* 
* @author Logan Lafauci
* @since 10/21/2019
*/
import java.util.Scanner;

public class Prog06_Psychic {

	public static void main(String[] args) {
		boolean check = true;
		int lower = 0;
		int higher = 0;
		double score = 0;
		double count = 0;
		Scanner in = new Scanner(System.in);
		
		System.out.printf("So you think you're psychic? Well, let's put that to the test!%n%nI will pick a number in a range, and you have to \"guess\" what the number is.%nI will let you pick the range.%n%n");
		//This checks to make sure the numbers are in order and have enough space to 
		while(check)
		{
			lower = bound("Enter lower bound of number range:");
			higher = bound("Enter upper bound (at least 3 numbers higher than " + lower + "):");
			if(higher > lower && (higher - lower) > 3)
			{
				check = false;
			}
			else
			{
				System.out.printf("The values entered are less than three spaces away and/or out of order%n%n");
			}
		}
		check = true;
		
		//This produces random numbers in the bound entered
		System.out.printf("Enter a whole number between %d and %d or Q to quit%n", lower, higher);
		while(check)
		{
			int psychicNum = lower + (int)(Math.random() * (higher - lower + 1));
			if(!in.hasNextInt())
			{
				check = false;
			}
			else if(in.nextInt() == psychicNum)
			{
				score ++;
				System.out.printf("Well, you must be psychic! You guessed the correct number: %d%n", psychicNum);
				System.out.printf("Enter a whole number between %d and %d or Q to quit%n", lower, higher);
				count ++;
			}
			else
			{
				System.out.printf("I am doubting your psychic abilities. You did not guess the correct number: %d%n", psychicNum);
				System.out.printf("Enter a whole number between %d and %d or Q to quit%n", lower, higher);
				count ++;
			}
		}
		
		//this calculates the amount guessed correctly and outputs the percentage 
		System.out.printf("%nYour success rate is %.7f%%.", (score / count) * 100);
	}
	
	//This method is used for input validation
	public static int bound(String ask)
	{
		Scanner in = new Scanner(System.in);
		System.out.println(ask);
		while(!in.hasNextInt())
		{
			String bad = in.next();
//			System.out.println("");
			System.out.printf("%nInvalid input%n");
			System.out.print(ask);
		}
		return in.nextInt();
	}

}
