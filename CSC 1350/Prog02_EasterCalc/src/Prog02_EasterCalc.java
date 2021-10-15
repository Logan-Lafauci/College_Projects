import java.util.Scanner;

/**
 * I am creating a program that will calculate the date of
 * easter using the algorithm developed by Gauss
 * the program will ask for user input 
 * 
 * CSC 1350 Programming project No 2
 * Section 2 LSU
 * 
 * @author Logan Lafauci
 * @since 9-16-2019
 * 
 */
public class Prog02_EasterCalc {

	public static void main(String[] args) {
		//Step 1: take users input year
		Scanner in = new Scanner(System.in);
		System.out.println("When is Easter, you ask?");
		System.out.print("Enter the year of your choosing: ");
		int year = in.nextInt(); //take the users year and make it variable year
		in.close();
		
		//Step 2: use the Gauss algorithm
		int a = year / 100; //divide y by 100 to get the quotient(/) a
		int b = year % 100; //divide y by 100 to get the remainder(%) b
		int c = a / 4; //divide a by 4 to get the quotient(/) c
		int f = a % 4; //divide a by 4 to get the remainder(%) f
		int g = (8 * a + 13) / 25; //divide (8 * a + 13) by 25 to get the quotient(/) g
		int h = year % 19; //divide year by 19 and call the remainder(%) h
		int i = b / 4; //divide b by 4 to get the quotient(/) i
		int j = b % 4; //divide b by 4 to get the remainder(%) j
		int k = (19 * h + a - c - g + 15) % 30; //divide (19 * h + a - c - g + 15) by 30 to get remainder(%) k
		int l = (h + 11 * k) / 319; //divide (h + 11 * k) by 319 to get the quotient(/) l
		int n = (2 * f + 2 * i - j - k + l + 32) % 7; //divide (2 * f + 2 * i - j - k + l + 32) by 7 to get the remainder(%) n
		int month = (k - l + n + 90) / 25; //divide (k - l + n + 90) by 25 to get the quotient(/) month
		int day = (k - l + n + month + 19) % 32; //divide (k - l + n + m + 19) by 32 to get the remainder(%) day
		
		//Step 3: output the results of the algorithm 
		System.out.printf("In %d, Easter falls on %d/%d.", year, month, day);
	}

}
