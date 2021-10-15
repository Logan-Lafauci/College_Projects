/**
* I will be creating a program that will help a user see how their
* stock investments have been trending over time
* 
* CSC 1350 Programming project No 8
* Section 2
* 
* @author Logan Lafauci
* @since 11/11/2019
*/
import java.util.Scanner;

public class Prog08_Trend {
	
	public static void main(String[] args) {
		//This creates an array for the user based on how many days they want to log then allows them to input the info for it 
		double[] closingValue = new double[arrayAmount("How many days would you like to trend?")];
		double average = 0;
		for(int i = 0; i < closingValue.length; i++)
		{
			closingValue[i] = valadation("Enter closing value for day " + (i + 1) +":");
			
			//average is calculating the average daily closing value
			average += closingValue[i];
		}
		if(closingValue.length == 0)
		{
			average = 0;
		}
		else
		{
			average = average / closingValue.length;
		}
		
		//This is where the information is being displayed for the user with his inputs and the trend he has 
		System.out.printf("%nDay    Closing Value    Trend%n");
		for(int i = 0; i < closingValue.length; i++)
		{
			System.out.printf("%3d %14.2f %10.2f %n", (i + 1), closingValue[i], (closingValue[i]- average));
		}
		System.out.printf("%nAverage Daily Closing Value: %.2f", average);
	}
	
	/**
	 * This method validates the users input while posing a question to the user 
	 * Developed: 10-28-2019
	 * Modified: 11-11-2019
	 * @author Logan Lafauci
	 * @param question is the question you want the user to answer 
	 * @return returns the users valid answer
	 */
	public static double valadation(String question)
	{
		boolean check = true;
		double num = 0;
		Scanner in = new Scanner(System.in);
		System.out.println(question);
		while(!in.hasNextDouble())
		{
			String bad = in.next();
			System.out.println("Enter in a valid number");
			System.out.println(question);
		}
		num = in.nextDouble();
		return num;
	}
	
	/**
	 * This method validates a number that the user inputs to create an array for the user
	 * Developed: 11-11-2019 
	 * @author Logan Lafauci
	 * @param question is the question you want the user to answer to create an array for info
	 * @return returns the users valid answer
	 */
	public static int arrayAmount(String question)
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
			if(num < 0)
			{
				System.out.println("Enter in a valid number");
				System.out.println(question);
			}
			else
			{
				check = false;
			}
		}
		return num;
	}
	
}
