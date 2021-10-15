/**
* I will be creating a program that forms a movie library
* and allows the user to search for specific titles in the library 
* 
* CSC 1350 Programming project No 8
* Section 2
* 
* @author Logan Lafauci
* @since 11/25/2019
*/
import java.util.Scanner;

public class Prog10_MovieLib {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean search = true;
		String movie = "";
		//This creates the amount of movies the library will consist of and assigns movies to a certain value
		String[] library = new String[arrayAmount("How many movies are in your personal library?")];
		for(int i = 0; i < library.length; i++)
		{
			System.out.println("Enter Movie Title:");
			library[i] = in.nextLine();
		}
		System.out.printf("%n%n");
		
		//This sorts the movies in the library by using my method called sort
		sort(library);
		
		//This searches for movies and gives the index of the movie until the user no longer wants to
		while(search)
		{
			boolean found = false;
			int position = -1;
			System.out.println("Enter a movie title to search or Q to stop:");
			movie = in.nextLine();
			if(movie.equals("Q"))
			{
				search = false;
			}
			else
			{
				for(int i = 0; i < library.length && !found; i++)
				{
					if(movie.equals(library[i]))
					{
						found = true;
						position = i;
						movie = library[i];
					}
				}
				if(found)
				{
					System.out.printf("The %s movie is in the library at position %d.%n", movie, position);
				}
				else
				{
					System.out.printf("%s is not a movie in the library.%n", movie);
				}
			}
		}
		System.out.printf("%n%nMovie Library:%n");
		
		//This output the movie library the user created
		for(int i = 0; i < library.length; i++)
		{
			System.out.println(library[i]);
		}
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
	
	/**
	 * This method does a short circuit search through an array and orders them in ascending order
	 * Developed: 11-28-2019 
	 * @author Logan Lafauci
	 * @param An array filled with string values 
	 */
	public static void sort(String array[])
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
						if(array[j].compareTo(array[j + 1]) > 0)
						{
							String hold = array[j];
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
