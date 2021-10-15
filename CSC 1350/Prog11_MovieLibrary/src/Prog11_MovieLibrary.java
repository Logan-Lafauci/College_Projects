import java.util.Scanner;

/**
* I will be creating a program that forms a movie library
* and Then prints out all the Info that was given for the movie
* 
* CSC 1350 Programming project No 8
* Section 2
* 
* @author Logan Lafauci
* @since 12/2/2019
*/
import java.util.Scanner;

public class Prog11_MovieLibrary {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// This is creating the array to store the object values in
		Movie[] library = new Movie[intValid("How many movies are in your personal library?")];
		for(int i = 0; i < library.length; i++)
		{
			library[i] = new Movie();
			System.out.println("Enter the movie title:");
			library[i].SetMovieTitle(in.nextLine());
			library[i].setReleaseYear(intValid("Enter the year that the movie was released:"));
			library[i].setRating(movieRating("Enter the movie rating (G, PG, PG-13, R, or Not Rated)"));
		}
		
		//this sorts the movies in alphabetical order by using a method that has been slightly modified 
		sort(library);
		
		//this outputs the info gathered above and in order
		System.out.printf("%n%nMovie Library:%n");
		for(int i = 0; i < library.length; i++)
		{
			System.out.printf("Movie Title:   %s%nRelease Year:  %d%nRating:        %s%n%n",library[i].MovieTitle(), library[i].ReleaseYear(), library[i].Rating());
			
			
		}
	}
	
	/**
	 * This method validates integers and uses 0 to keep numbers positive
	 * Developed: 12-2-2019 
	 * @author Logan Lafauci
	 * @param question is the question you want the user to answer to create an array for info
	 * @return returns the users valid answer
	 */
	public static int intValid(String question)
	{
		boolean check = true;
		int num = 0;
		Scanner in = new Scanner(System.in);
		System.out.println(question);
		while(check)
		{
			while(!in.hasNextInt())
			{
				String bad = in.nextLine();
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
	
	/**
	 * This method validates a movie rating system
	 * Developed: 12-2-2019 
	 * @author Logan Lafauci
	 * @param question is the question you want the user to answer to create an array for info
	 * @return returns the users valid answer
	 */
	public static String movieRating(String question)
	{
		boolean check = false;
		String rated = "";
		Scanner in = new Scanner(System.in);
		System.out.println(question);
		while(!check)
		{
			rated = in.nextLine();
			if(rated.equals("G") || rated.equals("PG") || rated.equals("PG-13") || rated.equals("R") || rated.equals("Not Rated"))
			{
				check = true;
			}
			else
			{
				System.out.println("Enter in a valid number");
				System.out.println(question);
			}
		}
		return rated;
	}
	
	/**
	 * This method does a short circuit search through an array and orders them in ascending order
	 * Developed: 11-28-2019 
	 * Modified: 12-2-2019
	 * @author Logan Lafauci
	 * @param An array filled with string values 
	 */
	public static void sort(Movie array[])
	{
		boolean sorted = false;
		int i = 1;
		while(!sorted)
		{
			if(i == array.length)
			{
				sorted = true;
			}
			else
			{
				sorted = true;
				for(int j = 0; j < array.length - i; j++)
				{
					if(array[j].MovieTitle().compareTo(array[j + 1].MovieTitle()) > 0)
					{
						Movie hold = array[j];
						array[j] = array [j + 1];
						array[j + 1] = hold;
						sorted = false;
					}
				}
			}
			i++;
		}
	}
}
